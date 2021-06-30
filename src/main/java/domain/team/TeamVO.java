package domain.team;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@Data
public class TeamVO {

    private Integer teamId;
    private String teamName;
    private String teamIcon;
    private String teamPublicYn;
    private String teamIntro;
    private String teamArea;
    private Date teamRegDate;


    public TeamVO(Team entity) {
        this.teamId         = entity.getTeamId();
        this.teamName       = entity.getTeamName();
        this.teamIcon       = entity.getTeamIcon();
        this.teamPublicYn   = entity.getTeamPublicYn();
        this.teamIntro      = entity.getTeamIntro();
        this.teamArea       = entity.getTeamArea();
        this.teamRegDate    = entity.getTeamRegDate();
    }

    public Team toEntity() {
        return Team.builder()
                .teamId(teamId)
                .teamName(teamName)
                .teamIcon(teamIcon)
                .teamPublicYn(teamPublicYn)
                .teamIntro(teamIntro)
                .teamArea(teamArea)
                .teamRegDate(teamRegDate)
                .build();
    }

}