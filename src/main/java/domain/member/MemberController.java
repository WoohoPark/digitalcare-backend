package domain.member;

import domain.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    /*
       회원 요청
     * MemberVO
     */
    @PostMapping("/request")
    public Integer insertMember(@RequestBody MemberVO vo) throws Exception {
        return memberService.insertMember(vo);
    }

    /*
       회원 여부 (승인/미승인)
     * userId
     * teamId
     * memberYn
     */
    @PostMapping("/signUp")
    public void updateMemberYn(@RequestBody MemberVO vo) throws Exception {
        memberService.updateMemberYn(vo);
    }

    /*
       회원 임명 (리더/부리더)
     * userId
     * teamId
     * leaderYn / subLeaderYn
     * 타입:L/S
     */
    @PostMapping("/appointment")
    public void updateAppointment(@RequestBody MemberVO vo,String type) throws Exception {
        memberService.updateAppointment(vo,type);
    }


    /*
        회원 목록
     */
    @GetMapping("/list")
    public List<MemberVO> selectMemberList(@RequestParam(value="page", defaultValue="1") Integer page, Integer teamId) throws Exception {
        return memberService.selectMemberList(teamId);
    }

}