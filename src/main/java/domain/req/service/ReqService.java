package domain.req.service;

import domain.req.Req;
import domain.req.ReqRepository;
import domain.req.ReqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReqService {

    @Autowired
    private ReqRepository reqRepository;

    @Transactional
    public void save(ReqVO reqVO) {
        reqRepository.save(reqVO.toEntity());
    }

    @Transactional
    public ReqVO get(int seq) {
        System.out.println("seq"+seq);
        Req req = reqRepository.findById(seq).orElseThrow(IllegalArgumentException::new);
        ReqVO reqVO = new ReqVO(req);
        return reqVO;
    }

    @Transactional
    public List<ReqVO> getList() {
        List<Req> reqs = reqRepository.findAll();
        List<ReqVO> reqList = new ArrayList<>();

        for (Req req : reqs) {
            ReqVO vo = new ReqVO(req);
            reqList.add(vo);
        }

        return reqList;
    }
}
