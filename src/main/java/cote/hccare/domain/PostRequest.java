package cote.hccare.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    private Long id;
    private String title;        // 제목
    private String content;      // 내용
    private String author;       // 작성자

}