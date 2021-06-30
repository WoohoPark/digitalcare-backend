package domain.review;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@Data
public class ReviewVO {

    private Integer teamId;
    private Integer userId;
    private String content;
    private Date regDate;

    public ReviewVO(Review entity) {
        this.teamId         = entity.getTeamId();
        this.userId         = entity.getUserId();
        this.content        = entity.getContent();
        this.regDate        = entity.getRegDate();
    }

    public Review toEntity() {
        return Review.builder()
                .teamId(teamId)
                .userId(userId)
                .content(content)
                .regDate(regDate)
                .build();
    }

}