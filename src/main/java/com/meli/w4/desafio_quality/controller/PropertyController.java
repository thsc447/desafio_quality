package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import com.meli.w4.desafio_quality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("/area")
    public ResponseEntity<PropertyResponse> calculatePropetyArea(@RequestBody @Valid Property property) {
        return ResponseEntity.ok().body(propertyService.calculateArea(property));
    }
}
