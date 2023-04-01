package com.project.orderfoodsproject.service;

import com.project.orderfoodsproject.dao.PlaceDao;
import com.project.orderfoodsproject.dto.PlaceDto;
import com.project.orderfoodsproject.entity.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceDao placeDao;
    public List<PlaceDto> getAllPlaces() {
        List<Place> places = placeDao.getAllPlaces();
        return places.stream()
                .map(PlaceDto::from)
                .collect(Collectors.toList());
    }
}
