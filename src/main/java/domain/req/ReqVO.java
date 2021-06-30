package domain.req;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@Data
public class ReqVO {

    private Integer matchId;
    private Integer reqTeamId;
    private String  memo;
    private String  type;
    private Date    regDate;

    public ReqVO(Req entity) {
        this.matchId       = entity.getMatchId();
        this.reqTeamId     = entity.getReqTeamId();
        this.memo          = entity.getMemo();
        this.type          = entity.getType();
        this.regDate       = entity.getRegDate();
    }

    public Req toEntity() {
        return Req.builder()
                .matchId(matchId)
                .reqTeamId(reqTeamId)
                .memo(memo)
                .type(type)
                .regDate(regDate)
                .build();
    }
}