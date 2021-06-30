package domain.match;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_MATCH")
@Getter
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;
    private Integer matchYn;
    private Integer matchHomeId;
    private Integer matchAwayId;
    private Integer matchTry;
    private Date matchDay;

    @Builder
    public Match(Integer matchId,
                 Integer matchYn,
                 Integer matchHomeId,
                 Integer matchAwayId,
                 Integer matchTry,
                 Date matchDay
                ) {
        this.matchId        = matchId;
        this.matchYn        = matchYn;
        this.matchHomeId    = matchHomeId;
        this.matchAwayId    = matchAwayId;
        this.matchTry       = matchTry;
        this.matchDay       = matchDay;
    }

}
