package domain.match.service;

import domain.match.Match;
import domain.match.MatchRepository;
import domain.match.MatchVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Transactional
    public void save(MatchVO matchVO) {
        matchRepository.save(matchVO.toEntity());
    }

    @Transactional
    public MatchVO get(int seq) {
        Match match = matchRepository.findById(seq).orElseThrow(IllegalArgumentException::new);
        MatchVO matchVO = new MatchVO(match);
        return matchVO;
    }

    @Transactional
    public List<MatchVO> getList() {
        List<Match> matchs = matchRepository.findAll();
        List<MatchVO> matchList = new ArrayList<>();

        for (Match match : matchs) {
            MatchVO vo = new MatchVO(match);
            matchList.add(vo);
        }

        return matchList;
    }
}
