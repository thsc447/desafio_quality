package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class DistrictController {

    @Autowired
    DistrictService districtService;

    /**
     * Endpoint para registrar lista de bairros
     *
     * @author Thomaz Ferreira
     * @param districts
     * @param uriBuilder
     * @return ResponseEntity
     */
    @PostMapping("/registerDistrict")
    private ResponseEntity<Map<String, String>> registerDistricts(@RequestBody @Valid DistrictDTO districts, UriComponentsBuilder uriBuilder) throws IOException{
        URI uri = uriBuilder.path("/getDistricts").build().toUri();
        return districtService.saveDistricts(districts, uri);
    }


    /**
     * Endpoint para recuperar todos bairros cadastrados
     *
     * @author Thomaz Ferreira
     * @return ResponseEntity
     */
    @GetMapping("/getDistricts")
    private ResponseEntity<DistrictDTO> getDistricts() throws IOException {
        return districtService.getAllDistricts();
    }
}
