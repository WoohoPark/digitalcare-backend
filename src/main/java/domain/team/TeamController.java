package domain.team;

import domain.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    /*
    팀 생성
     */
    @PostMapping("/create")
    public Integer teamCreate(@RequestBody TeamVO vo) throws Exception {
        return teamService.save(vo);
    }

    /*
    팀 목록
     */
    @GetMapping("/list")
    public List<TeamVO> teamList(@RequestParam(value="page", defaultValue="1") Integer page) throws Exception {
        return teamService.getList();
    }

    /*
    팀 정보
     */
    @GetMapping("/info")
    public TeamVO teamInfo(int teamId) throws Exception {
        return teamService.getInfo(teamId);
    }

}
