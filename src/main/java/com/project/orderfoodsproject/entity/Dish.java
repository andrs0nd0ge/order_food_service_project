package com.project.orderfoodsproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dish {
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Long placeId;
}
