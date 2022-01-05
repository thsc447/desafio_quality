package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.RoomDTO;
import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public PropertyResponse calculateArea(Property property) {
        return PropertyResponse.builder().build();
    }

    public String getBiggestRoom(List<RoomDTO> roomsDTO) {
        Collections.sort(roomsDTO);
        return roomsDTO.get(roomsDTO.size() - 1).getRoom_name();
    }
}
