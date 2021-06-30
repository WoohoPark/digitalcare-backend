package domain.member.service;

import domain.member.Member;
import domain.member.MemberRepository;
import domain.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Integer insertMember(MemberVO vo) {
        return memberRepository.save(vo.toEntity()).getTeamId();
    }

    @Transactional
    public List<MemberVO> selectMemberList(int teamId) {

        List<Member> members = memberRepository.findAll();
        List<MemberVO> memberList = new ArrayList<>();

        for (Member member : members) {
            MemberVO vo = new MemberVO(member);
            memberList.add(vo);
        }

        return memberList;
    }

    @Transactional
    public void updateMemberYn(MemberVO vo) {
        memberRepository.updateMemberYn(vo.getMemberYn(),vo.getTeamId(),vo.getUserId());
    }

    @Transactional
    public void updateAppointment(MemberVO vo, String type) {

        Integer leaderYn      = vo.getLeaderYn();
        Integer subLeaderYn   = vo.getSubLeaderYn();
        Integer teamId        = vo.getTeamId();
        Integer userId        = vo.getUserId();

        if("L".equals(type)){
            memberRepository.updateLeaderYn(leaderYn,teamId,userId);
        }else if ("S".equals(type)){
            memberRepository.updateSubLeaderYn(subLeaderYn,teamId,userId);
        }

    }
}
