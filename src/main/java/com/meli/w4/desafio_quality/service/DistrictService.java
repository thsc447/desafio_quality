package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DistrictService {

    /**
     * Faz persistência de bairros em um arquivo JSON
     *
     * @author Thomaz Ferreira
     * @param districts
     * @return ResponseEntity
     */
    public void saveDistricts(DistrictDTO districts) {
		DistrictRepository.serializeDistricts(districts.getDistricts());
    }


    /**
     * Retorna lista de bairros desserializados
     *
     * @author Thomaz Ferreira
     * @return DistrictDTO
     */
    public DistrictDTO getAllDistricts() {
        List<District> unserializedDistrics = DistrictRepository.unserializeDistricts();
        return DistrictDTO.parseToDTO(unserializedDistrics);
    }
}
