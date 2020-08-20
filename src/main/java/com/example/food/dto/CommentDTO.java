package com.example.food.dto;

import com.example.food.vo.Comment;
import lombok.Data;

@Data
public class CommentDTO {

    private Long id;
    private String author;
    private String content;


    /*
    리파지토리에 들어가야 해서
    * new Comment(id, author, content); 랑 같다
    * 디비에 레코드가 저장될떄 id가 생긴다
    그림
    * */
    public Comment toEntity() {
        return Comment.builder()
                .id(id)
                .author(author)
                .content(content)
                .build();
    }

}
