package com.project.orderfoodsproject.controller;

import com.project.orderfoodsproject.dto.OrderDto;
import com.project.orderfoodsproject.dto.OwnOrderDto;
import com.project.orderfoodsproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PostMapping("/{dishId}")
    public void makeOrder(Authentication auth, @PathVariable Long dishId) {
        orderService.makeOrder(auth, dishId);
    }
    @GetMapping
    public ResponseEntity<List<OwnOrderDto>> getOwnOrders(Authentication auth) {
        List<OwnOrderDto> orders = orderService.getOwnOrders(auth);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
