package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.repository.DistrictRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistrictService {

    public ResponseEntity<Map<String, String>> gravaBairro(List<District> districts, URI uri){
        DistrictRepository.serializaDistricts(districts);
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        response.put("message", "Bairros cadastrados com sucesso");
        return ResponseEntity.created(uri).body(response);
    }
}
