package com.example.food.controller;


import com.example.food.dto.FoodDTO;
import com.example.food.repository.FoodRepository;
import com.example.food.vo.FoodVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/")
    public String index(Model model) {
        List<FoodVO> foodList = foodRepository.findAll();
        model.addAttribute("foodList", foodList);

        return "foods/index";
    }

    @GetMapping("/foods/new")
    public String newFood() {
        return "foods/new";
    }

    @PostMapping("/foods/create")
    public String create(FoodDTO dto) {
        log.info(dto.toString());

        FoodVO foodVO = dto.toEntity();
        log.info(foodVO.toString());

        FoodVO vo = foodRepository.save(foodVO);
        log.info(vo.toString());


        return "redirect:/";
    }


    @GetMapping("/init")
    public String init() {
        List<FoodVO> foodList = new ArrayList<>();
        foodList.add(new FoodVO(null, "바밤바", 800));
        foodList.add(new FoodVO(null, "쌍쌍바", 1500));
        foodList.add(new FoodVO(null, "초코퍼지", 800));

        foodRepository.saveAll(foodList);

        return "redirect:/";
    }

    @GetMapping("/foods/{id}")
    public String detail(@PathVariable Long id, Model model) {
        FoodVO foodVO = foodRepository.findById(id).orElse(null);
        model.addAttribute("foodVO", foodVO);
        return "foods/show";//상대경로라서 루트를 안쓴다
    }

    @GetMapping("/foods/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        FoodVO foodVO = foodRepository.findById(id).orElse(null);
        model.addAttribute("foodVO", foodVO);
        return "foods/edit";
    }



    @PostMapping("/food/update/{id}")
    public String update(@PathVariable Long id, FoodDTO foodDTO) {
        FoodVO foodVO = foodDTO.toEntity();
        log.info(foodVO.toString());

        FoodVO saved = foodRepository.save(foodVO);
        log.info(saved.toString());
        return "redirect:/foods/" + id;
    }

    
    @GetMapping("/foods/delete/{id}")
    public String delete(@PathVariable Long id) {
        foodRepository.deleteById(id);
        log.info(id + "번 삭제 완료");
        return "redirect:/";
    }

}
