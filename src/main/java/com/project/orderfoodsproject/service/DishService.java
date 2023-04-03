package com.project.orderfoodsproject.service;

import com.project.orderfoodsproject.dao.DishDao;
import com.project.orderfoodsproject.dto.DishDto;
import com.project.orderfoodsproject.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishDao dishDao;
    public List<DishDto> getAllDishes() {
        List<Dish> dishes = dishDao.getAllDishes();
        return dishes.stream()
                .map(DishDto::from)
                .collect(Collectors.toList());
    }
    public List<DishDto> getAllDishesFromPlace(Long placeId) {
        List<Dish> ownDishes = dishDao.getAllDishesFromPlace(placeId);
        return ownDishes.stream()
                .map(DishDto::from)
                .collect(Collectors.toList());
    }
}
