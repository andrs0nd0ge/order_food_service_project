package com.project.orderfoodsproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.orderfoodsproject.entity.Dish;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnOrderDto {
    private String name;
    private String type;
    private Double price;
    @JsonProperty("place_id")
    private Long placeId;
    public static OwnOrderDto from(Dish dish) {
        return builder()
                .name(dish.getName())
                .type(dish.getType())
                .price(dish.getPrice())
                .placeId(dish.getPlaceId())
                .build();
    }
}
