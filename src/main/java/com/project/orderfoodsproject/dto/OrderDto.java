package com.project.orderfoodsproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.orderfoodsproject.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    @JsonProperty("client_id")
    private Long clientId;
    @JsonProperty("dish_id")
    private Long dishId;
    private LocalDate date;
    public static OrderDto from(Order order) {
        return builder()
                .id(order.getId())
                .clientId(order.getClientId())
                .dishId(order.getDishId())
                .date(order.getDate())
                .build();
    }
}
