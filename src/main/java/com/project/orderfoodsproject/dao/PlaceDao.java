package com.project.orderfoodsproject.dao;

import com.project.orderfoodsproject.entity.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlaceDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Place> getAllPlaces() {
        String sql = "select * from places";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Place.class));
    }
}
