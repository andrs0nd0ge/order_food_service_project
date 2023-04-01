package com.project.orderfoodsproject.util;

import com.project.orderfoodsproject.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
@AllArgsConstructor
public class UtilityClass {
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder encoder;
    public void createPlacesTable() {
        String sql = "create table if not exists places " +
                "( " +
                "    id          bigserial " +
                "        primary key " +
                "        unique, " +
                "    name        text not null, " +
                "    description text " +
                ");";
        jdbcTemplate.execute(sql);
    }
    public void insertIntoPlaces() {
        String sql = "insert into places (name, description) values " +
                "('The Skinny Nomad', 'description'), " +
                "('The Princess Tavern', 'some description'), " +
                "('Cafe Latter', 'another desc'), " +
                "('Ponderosa Pines', 'some other description'), " +
                "('Posados', 'another description')";
        jdbcTemplate.execute(sql);
    }
    public void createDishesTable() {
        String sql = "create table if not exists dishes " +
                "( " +
                "    id    bigserial " +
                "        primary key " +
                "        unique, " +
                "    name  text not null, " +
                "    type  text, " +
                "    price decimal default 0, " +
                "    place_id bigint " +
                "    constraint dishes_place_fk " +
                "     references places " +
                "             on update cascade on delete cascade " +
                ");";
        jdbcTemplate.execute(sql);
    }
    public void insertIntoDishes() {
        String sql = "insert into dishes (name, price, type, place_id) values " +
                "('Lemon bars', 1.79, 'Dessert', 2), " +
                "('Red velvet cake', 5.11, 'Dessert', 1), " +
                "('Padana', 3.79, 'Pizza', 5), " +
                "('Espresso', 0.69, 'Hot Beverage', 3), " +
                "('Red kibble', 3, 'Belter food', 4), " +
                "('Vat grown steak', 4.19, 'Belter food', 1), " +
                "('Rice with the extra hot gravy', 2.3, 'Belter food', 4), " +
                "('Lemon meringue pie', 1.89, 'Dessert', 3), " +
                "('Sweet roll', 2.34, 'Dessert', 2), " +
                "('Diavola', 3.49, 'Pizza', 5)";
        jdbcTemplate.execute(sql);
    }
    public void createClientsTable() {
        String sql = "create table if not exists clients " +
                "( " +
                "    id       bigserial " +
                "        primary key " +
                "        unique, " +
                "    username text, " +
                "    email    text not null " +
                "        unique, " +
                "    password text " +
                ");";
        jdbcTemplate.execute(sql);
    }
    public void insertIntoClients() {
        Client userOne = new Client();
        userOne.setPassword(encoder.encode("123"));
        Client userTwo = new Client();
        userTwo.setPassword(encoder.encode("123"));
        Client userThree = new Client();
        userThree.setPassword(encoder.encode("123"));
        String sql = "insert into clients (username, email, password) values " +
                "('Tu Woodie', 'woodie@test', ?), " +
                "('Matilde Wexler', 'wexler@test', ?), " +
                "('Virgilio Vantassell', 'virgilio@test', ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userOne.getPassword());
            ps.setString(2, userTwo.getPassword());
            ps.setString(3, userThree.getPassword());
            return ps;
        });
    }
    public void createOrdersTable() {
        String sql = "create table if not exists orders " +
                "( " +
                "    id        bigserial " +
                "        primary key " +
                "        unique, " +
                "    client_id bigint " +
                "        constraint orders_client_fk " +
                "            references clients " +
                "            on update cascade on delete cascade, " +
                "    dish_id   bigint " +
                "        constraint orders_food_fk " +
                "            references dishes " +
                "            on update cascade on delete cascade, " +
                "    date      date default current_date " +
                ");";
        jdbcTemplate.execute(sql);
    }
    public void insertIntoOrders() {
        String sql = "insert into orders (client_id, dish_id) " +
                "values (3, 4), " +
                "       (1, 3), " +
                "       (2, 1), " +
                "       (1, 5), " +
                "       (3, 3), " +
                "       (2, 2)";
        jdbcTemplate.execute(sql);
    }
}
