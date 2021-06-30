package domain.match;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@Data
public class MatchVO {

    private Integer matchId;
    private Integer matchYn;
    private Integer matchHomeId;
    private Integer matchAwayId;
    private Integer matchTry;
    private Date matchDay;

    public MatchVO(Match entity) {
        this.matchId        = entity.getMatchId();
        this.matchYn        = entity.getMatchYn();
        this.matchHomeId    = entity.getMatchHomeId();
        this.matchAwayId    = entity.getMatchAwayId();
        this.matchTry       = entity.getMatchTry();
        this.matchDay       = entity.getMatchDay();
    }

    public Match toEntity() {
        return Match.builder()
                .matchId(matchId)
                .matchYn(matchYn)
                .matchHomeId(matchHomeId)
                .matchAwayId(matchAwayId)
                .matchTry(matchTry)
                .matchDay(matchDay)
                .build();
    }
}