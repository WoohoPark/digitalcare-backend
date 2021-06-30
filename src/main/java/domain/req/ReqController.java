package domain.req;

import domain.req.service.ReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/req")
public class ReqController {

    @Autowired
    ReqService reqService;

    /*
        요청 (매칭)
     */
    @PostMapping("/create")
    public void reqInsert(@RequestBody ReqVO vo) throws Exception{
        reqService.save(vo);
    }

    /*
        요청 취소
     */
    @PostMapping("/list")
    public void reqDelete(@RequestBody ReqVO vo) throws Exception{
        //return boardService.save(vo);
    }

    /*
        요청
     */
    @PostMapping("/update")
    public void reqUpdate(@RequestBody ReqVO vo) throws Exception{
        //return boardService.save(vo);
    }

    @PostMapping("/info")
    public void reqInfo(@RequestBody ReqVO vo) throws Exception{
        //return boardService.save(vo);
    }

}
