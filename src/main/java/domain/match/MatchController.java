package domain.match;

import domain.match.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    /*
        매치 생성
     */
    @PostMapping("/create")
    public void matchInsert(@RequestBody MatchVO vo) throws Exception{
        //return boardService.save(vo);
    }

    /*
        매치 리스트
     */
    @PostMapping("/list")
    public void matchDelete(@RequestBody MatchVO vo) throws Exception{
        //return boardService.save(vo);
    }

    /*
        매치 수정
     */
    @PostMapping("/update")
    public void matchUpdate(@RequestBody MatchVO vo) throws Exception{
        //return boardService.save(vo);
    }

    /*
        매치 정보
     */
    @PostMapping("/info")
    public void matchInfo(@RequestBody MatchVO vo) throws Exception{
        //return boardService.save(vo);
    }

}
