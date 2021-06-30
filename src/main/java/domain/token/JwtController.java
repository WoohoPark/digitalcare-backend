package domain.token;

import domain.token.exception.base.CommonException;
import domain.token.jwt.JwtComponent;
import domain.token.jwt.domain.Jwt;
import domain.token.security.AuthenticationRequest;
import domain.token.security.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {

    @Autowired
    private JwtComponent jwtUtil;

    /**
     * 토큰생성요청
     * @param authenticationRequest
     * @return
     * @throws CommonException, Exception
     * @throws Exception
     */
    @RequestMapping( value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate (@RequestBody AuthenticationRequest authenticationRequest) throws CommonException, Exception{

        Jwt token = this.jwtUtil.makeJwt(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return ResponseEntity.ok(  new AuthenticationResponse(token));
    }

    /**
     * 리프레시토큰으로 토큰재발급
     * @return
     * @throws Exception
     */
    @RequestMapping( value = "/get_access_token", method = RequestMethod.POST)
    public ResponseEntity<?> get_access_token() throws Exception{

        Jwt token = this.jwtUtil.makeReJwt();
        return ResponseEntity.ok(  new AuthenticationResponse(token));
    }
}