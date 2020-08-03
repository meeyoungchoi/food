package com.example.food.dto;

import com.example.food.vo.FoodVO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodDTO {
    private Long id;
    private String name;
    private Integer price;

    public FoodVO toEntity() {
        return new FoodVO(id, name, price);
    }




}
