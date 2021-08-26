package domain.push;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/api/push")
public class PushController{

    @RequestMapping(value="/test",produces="text/plain;charset=UTF-8")
    public void pushTest(@Value("${firebase.push.key.path}")String path,
                         @Value("${firebase.push.scope}")String MESSAGING_SCOPE,
                         @Value("${firebase.push.send.url}")String SEND_URL,
                         @RequestParam(value="token", required = true) String token,
                         @RequestParam(value="title", required = true) String title,
                         @RequestParam(value="body", required = true) String body) throws Exception{
        try{

            String[] SCOPES = MESSAGING_SCOPE.split(",");

            GoogleCredential googleCredential = GoogleCredential
                    .fromStream(new FileInputStream(path))
                    .createScoped(Arrays.asList(SCOPES));
            googleCredential.refreshToken();

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type" , MediaType.APPLICATION_JSON_VALUE);
            headers.add("Authorization", "Bearer " + googleCredential.getAccessToken());

            JSONObject notification = new JSONObject();
            notification.put("body", body);
            notification.put("title", title);

            JSONObject message = new JSONObject();
            message.put("token", token);
            message.put("notification", notification);

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("message", message);

            HttpEntity<JSONObject> httpEntity = new HttpEntity<JSONObject>(jsonParams, headers);
            RestTemplate rt = new RestTemplate();

            ResponseEntity<String> res = rt.exchange(SEND_URL
                    , HttpMethod.POST
                    , httpEntity
                    , String.class);

            if (res.getStatusCode() != HttpStatus.OK) {
                System.out.println("notok");
                System.out.println(res.getStatusCode().toString());
                System.out.println(res.getHeaders().toString());
                System.out.println(res.getBody().toString());

            } else {
                System.out.println(res.getStatusCode().toString());
                System.out.println(res.getHeaders().toString());
                System.out.println(res.getBody().toLowerCase());

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}