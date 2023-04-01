package com.project.orderfoodsproject.controller;

import com.project.orderfoodsproject.dto.DishDto;
import com.project.orderfoodsproject.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    @GetMapping
    public ResponseEntity<List<DishDto>> getDishes() {
        List<DishDto> dishes = dishService.getAllDishes();
        if (dishes.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }
    @GetMapping("/{placeId}")
    public ResponseEntity<List<DishDto>> getAllDishesFromPlace(@PathVariable Long placeId) {
        List<DishDto> dishes = dishService.getAllDishesFromPlace(placeId);
        if (dishes.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }
}
