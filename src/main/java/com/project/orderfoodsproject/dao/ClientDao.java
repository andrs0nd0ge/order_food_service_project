package com.project.orderfoodsproject.dao;

import com.project.orderfoodsproject.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public Optional<Client> getClientByEmail(String email) {
        String sql = String.format("select * from clients where email = '%s'", email);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class))
                .stream()
                .findFirst();
    }
}
