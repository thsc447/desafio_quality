package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public PropertyResponse calculateArea(Property property) {
        return new PropertyResponse();
    }


    public Double calculateTotalArea(List<Room> rooms) {
        return rooms.stream()
                .map(room -> room.getRoom_length() * room.getRoom_width())
                .reduce((a, b) -> a + b)
                .get();
    }

    public BigDecimal calculateTotalPriceOfProperty(Property property) {
        return null;
    }
}
