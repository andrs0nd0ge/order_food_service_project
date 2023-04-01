package com.project.orderfoodsproject.controller;

import com.project.orderfoodsproject.dto.PlaceDto;
import com.project.orderfoodsproject.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;
    @GetMapping
    public List<PlaceDto> getPlaces() {
        return placeService.getAllPlaces();
    }
}
