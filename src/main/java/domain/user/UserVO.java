package domain.user;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class UserVO {

    private Integer seq;
    private String title;
    private String content;
    private String author;

    public UserVO(User entity) {
        this.seq = entity.getSeq();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

    public User toEntity() {
        return User.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}