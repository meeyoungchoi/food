package com.example.food.repository;

import com.example.food.vo.FoodVO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<FoodVO, Long> {
    @Override
    List<FoodVO> findAll();
}
