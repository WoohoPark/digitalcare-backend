package domain.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_REVIEW")
@Getter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3.
    private Integer reviewId;
    private Integer teamId;
    private Integer userId;
    private String content;
    private Date regDate;

    @Builder
    public Review(Integer teamId,
                  Integer userId,
                  String content,
                  Date   regDate) {
        this.teamId         = teamId;
        this.userId         = userId;
        this.content        = content;
        this.regDate        = regDate;
    }

}
