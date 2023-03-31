package com.project.orderfoodsproject.dao;

import com.project.orderfoodsproject.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Client> getAllClients() {
        String sql = "select * from clients";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }
    public void registerClient(String username, String email, String password) {
        String sql = String.format("insert into clients (username, email, password) " +
                "values ('%s', '%s', '%s')", username, email, password);
        jdbcTemplate.execute(sql);
    }
}
