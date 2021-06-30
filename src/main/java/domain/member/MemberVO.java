package domain.member;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@Data
public class MemberVO {

    private Integer teamId;
    private Integer userId;
    private Integer leaderYn;
    private Integer subLeaderYn;
    private Integer memberYn;
    private String joinMemo;
    private Date   joinDate;
    private Date   reqDate;

    public MemberVO(Member entity) {
        this.teamId         = entity.getTeamId();
        this.userId         = entity.getUserId();
        this.leaderYn       = entity.getLeaderYn();
        this.subLeaderYn    = entity.getSubLeaderYn();
        this.memberYn       = entity.getMemberYn();
        this.joinDate       = entity.getJoinDate();
        this.reqDate       = entity.getReqDate();
        this.joinMemo       = entity.getJoinMemo();
    }

    public Member toEntity() {
        return Member.builder()
                .teamId(teamId)
                .userId(userId)
                .leaderYn(leaderYn)
                .subLeaderYn(subLeaderYn)
                .memberYn(memberYn)
                .joinMemo(joinMemo)
                .joinDate(joinDate)
                .reqDate(reqDate)
                .build();
    }

}