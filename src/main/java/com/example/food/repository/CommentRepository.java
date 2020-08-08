package com.example.food.repository;

import com.example.food.vo.Comment;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {




}
