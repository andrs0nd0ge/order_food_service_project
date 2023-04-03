package com.project.orderfoodsproject.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Order {
    private Long id;
    private Long clientId;
    private Long dishId;
    private LocalDate date;
}
