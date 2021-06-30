package domain.team.service;

import domain.board.Board;
import domain.team.Team;
import domain.team.TeamRepository;
import domain.team.TeamVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public Integer save(TeamVO vo) {
        return teamRepository.save(vo.toEntity()).getTeamId();
    }

    @Transactional
    public List<TeamVO> getList() {
        List<Team> teams = teamRepository.findAll();
        List<TeamVO> teamList = new ArrayList<>();

        for (Team team : teams) {
            TeamVO vo = new TeamVO(team);
            teamList.add(vo);
        }

        return teamList;
    }

    @Transactional
    public TeamVO getInfo(int teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(IllegalArgumentException::new);
        TeamVO vo = new TeamVO(team);
        return vo;
    }

}
