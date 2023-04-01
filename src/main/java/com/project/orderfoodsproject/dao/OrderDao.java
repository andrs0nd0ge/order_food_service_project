package com.project.orderfoodsproject.dao;

import com.project.orderfoodsproject.entity.Dish;
import com.project.orderfoodsproject.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Order> getAllOrders() {
        String sql = "select * from orders";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
    }
    public void makeOrder(Long clientId, Long dishId) {
        String sql = String.format("insert into orders (client_id, dish_id) " +
                "values (%s, %s)", clientId, dishId);
        jdbcTemplate.execute(sql);
    }
    public List<Dish> getOwnOrders(Long clientId) {
        String sql = String.format("select d.name, d.type, d.price, d.place_id from orders as o " +
                "left join dishes as d on d.id = o.dish_id " +
                "where client_id = %s", clientId);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class));
    }
}
