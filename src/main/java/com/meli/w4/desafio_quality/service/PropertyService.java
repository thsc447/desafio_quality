package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.RoomDTO;
import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public PropertyResponse calculateArea(Property property) {
        return PropertyResponse.builder().build();
    }

    public List<RoomDTO> calculateAreaByRoom(Property property) {
        return property.getRooms().stream()
                .map(RoomDTO::convert)
                .collect(Collectors.toList());
    }

    public String getBiggestRoom(List<RoomDTO> roomsDTO) {
        Collections.sort(roomsDTO);
        return roomsDTO.get(roomsDTO.size() - 1).getRoom_name();
    }

    public double getPropetyArea(List<Room> rooms) {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getRoom_length() * room.getRoom_width();
        }
        return totalArea;
    }
}
