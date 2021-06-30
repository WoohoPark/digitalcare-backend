package domain.member;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberPk implements Serializable {

    private Integer teamId;

    private Integer userId;
}
