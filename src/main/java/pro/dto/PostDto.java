package pro.dto;

import lombok.Data;

@Data
public class PostDto {

    private int num;
    private String title;
    private String writer;
    private String content;
    private String regDate; // Date 타입을 String으로 변경

    // Lombok의 @Data 어노테이션을 사용하면 Getter, Setter, toString() 등을 자동으로 생성해줍니다.
}

