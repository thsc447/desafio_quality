package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class DistrictController {

    @Autowired
    DistrictService districtService;

    /**
     * @author Thomaz Ferreira
     * @param districts
     * @param uriBuilder
     * @return ResponseEntity
     */
    @PostMapping("/registerDistrict")
    private ResponseEntity<Map<String, String>> cadastraBairro(@Valid @RequestBody List<District> districts, UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/getDistricts").build().toUri();
        return districtService.gravaBairro(districts, uri);
    }
}
