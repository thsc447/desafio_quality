package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public PropertyResponse calculateArea(Property property) {
        return new PropertyResponse();
    }

    public BigDecimal calculateTotalPriceOfProperty(Property property){
        return null;
    }
}
