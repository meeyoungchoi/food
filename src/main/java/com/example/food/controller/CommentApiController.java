package com.example.food.controller;

import com.example.food.dto.CommentDTO;
import com.example.food.repository.CommentRepository;
import com.example.food.vo.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentRepository commentRepository;

    @PostMapping("/api/comments/{articleId}")
    public Long create(@PathVariable  Long articleId,
                       @RequestBody CommentDTO
                               form) {
        log.info("form: " + form.toString());
       Comment saved = commentRepository.save(form.toEntity());
       log.info("saved: " + saved.toString());
        return 0L;
    }


}
