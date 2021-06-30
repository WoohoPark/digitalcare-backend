package domain.board;

import lombok.*;

@Getter
@NoArgsConstructor
@Data
public class BoardVO {

    private Integer seq;
    private String title;
    private String content;
    private String author;

    public BoardVO(Board entity) {
        this.seq = entity.getSeq();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}