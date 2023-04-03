package com.project.orderfoodsproject.dto;

import com.project.orderfoodsproject.entity.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto {
    private Long id;
    private String name;
    private String description;
    public static PlaceDto from(Place place) {
        return builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .build();
    }
}
