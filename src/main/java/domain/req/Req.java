package domain.req;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_REQ")
@Getter
@NoArgsConstructor
public class Req {

    @Id
    private Integer matchId;
    private Integer reqTeamId;
    private String  memo;
    private String  type;
    private Date    regDate;

    @Builder
    public Req(Integer matchId,
               Integer reqTeamId,
               String memo,
               String type,
               Date regDate
                ) {
        this.matchId        = matchId;
        this.reqTeamId      = reqTeamId;
        this.memo           = memo;
        this.type           = type;
        this.regDate        = regDate;
    }

}
