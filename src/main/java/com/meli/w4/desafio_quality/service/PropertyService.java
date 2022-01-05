package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.RoomDTO;
import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public PropertyResponse calculateAreaTotal(Property property) {
        Double totalArea = this.calculateAreaByRoom(property).stream()
                .mapToDouble(RoomDTO::getArea)
                .sum();

        return PropertyResponse.builder()
                .totalArea(totalArea)
                .price(this.calculateTotalPriceOfProperty(property))
                .biggestRoom(this.getBiggestRoom(property))
                .rooms(RoomDTO.convertList(property.getRooms()))
                .build();
    }

    public List<RoomDTO> calculateAreaByRoom(Property property) {
        return property.getRooms().stream()
                .map(RoomDTO::convert)
                .collect(Collectors.toList());
    }

    public String getBiggestRoom(Property property) {
        List<RoomDTO> sortedRoomDto = this.calculateAreaByRoom(property).stream()
                .sorted(Comparator.comparing(RoomDTO::getArea))
                .collect(Collectors.toList());
        return sortedRoomDto.get(sortedRoomDto.size() - 1).getRoom_name();
    }

    public double getPropetyArea(List<Room> rooms) {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getRoom_length() * room.getRoom_width();
        }
        return totalArea;
    }

    public Double calculateTotalArea(List<Room> rooms) {
        return rooms.stream()
                .map(room -> room.getRoom_length() * room.getRoom_width())
                .reduce((a, b) -> a + b)
                .get();
    }

    public BigDecimal calculateTotalPriceOfProperty(Property property) {
        return property.getValue_district_m2()
                .multiply(BigDecimal.valueOf(calculateTotalArea(property.getRooms())));
    }
}
