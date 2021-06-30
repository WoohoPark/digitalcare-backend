package domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MEMBER")
@Getter
@NoArgsConstructor
@IdClass(MemberPk.class)
public class Member {

    @Id
    @Column(name="teamId")
    private Integer teamId;

    @Id
    @Column(name="userId")
    private Integer userId;
    private Integer leaderYn;
    private Integer subLeaderYn;
    private Integer memberYn;
    private String joinMemo;
    private Date   joinDate;
    private Date   reqDate;

    @Builder
    public Member(Integer teamId,
                  Integer userId,
                  Integer leaderYn,
                  Integer subLeaderYn,
                  Integer memberYn,
                  String joinMemo,
                  Date   joinDate,
                  Date   reqDate
                ) {
        this.teamId         = teamId;
        this.userId         = userId;
        this.leaderYn       = leaderYn;
        this.subLeaderYn    = subLeaderYn;
        this.memberYn       = memberYn;
        this.joinMemo       = joinMemo;
        this.joinDate       = joinDate;
        this.reqDate       = reqDate;
    }

}
