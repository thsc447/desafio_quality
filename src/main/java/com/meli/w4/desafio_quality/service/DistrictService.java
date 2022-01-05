package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.repository.DistrictRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class DistrictService {

    public ResponseEntity<?> gravaBairro(List<District> districts, URI uri){
        DistrictRepository.serializaDistricts(districts);
        return ResponseEntity.created(uri).body(districts);
    }
}
