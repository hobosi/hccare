package cote.hccare.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private Long id;                       // PK
    private String title;                  // 제목
    private String content;                // 내용
    private String author;                 // 작성자
    private LocalDateTime createdAt;        // 생성일시

}