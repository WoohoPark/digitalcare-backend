package domain.team;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_TEAM")
@Getter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;
    private String teamName;
    private String teamIcon;
    private String teamPublicYn;
    private String teamIntro;
    private String teamArea;
    private Date   teamRegDate;

    @Builder
    public Team(Integer teamId,
                String teamName,
                String teamIcon,
                String teamPublicYn,
                String teamIntro,
                String teamArea,
                Date   teamRegDate
                ) {
        this.teamId         = teamId;
        this.teamName       = teamName;
        this.teamIcon       = teamIcon;
        this.teamPublicYn   = teamPublicYn;
        this.teamIntro      = teamIntro;
        this.teamArea       = teamArea;
        this.teamRegDate    = teamRegDate;
    }

}
