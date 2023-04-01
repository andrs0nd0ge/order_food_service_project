package com.project.orderfoodsproject.service;

import com.project.orderfoodsproject.dao.DishDao;
import com.project.orderfoodsproject.dao.OrderDao;
import com.project.orderfoodsproject.dto.OrderDto;
import com.project.orderfoodsproject.dto.OwnOrderDto;
import com.project.orderfoodsproject.entity.Client;
import com.project.orderfoodsproject.entity.Dish;
import com.project.orderfoodsproject.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderDao.getAllOrders();
        return orders.stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }
    public String makeOrder(Authentication auth, Long dishId) {
        String response = "";
        List<Order> orders = orderDao.getAllOrders();
        for (Order order : orders) {
            if (dishId.equals(order.getId())) {
                Client user = (Client) auth.getPrincipal();
                orderDao.makeOrder(user.getId(), dishId);
                response = "Order has been completed. Enjoy your meal!";
            } else {
                response = "A dish with given ID doesn't exist. Please, try again";
            }
            break;
        }
        return response;
    }
    public List<OwnOrderDto> getOwnOrders(Authentication auth) {
        Client user = (Client) auth.getPrincipal();
        List<Dish> ownOrders = orderDao.getOwnOrders(user.getId());
        return ownOrders.stream()
                .map(OwnOrderDto::from)
                .collect(Collectors.toList());
    }
}
