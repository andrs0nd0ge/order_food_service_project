package com.project.orderfoodsproject.dao;

import com.project.orderfoodsproject.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DishDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Dish> getAllDishes() {
        String sql = "select * from dishes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class));
    }
    public List<Dish> getAllDishesFromPlace(Long placeId) {
        String sql = String.format("select * from dishes where place_id = %s", placeId);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class));
    }
}
