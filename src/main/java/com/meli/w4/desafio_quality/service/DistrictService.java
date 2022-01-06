package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.repository.DistrictRepository;
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
     * @param uri
     * @return ResponseEntity
     */
    public ResponseEntity<Map<String, String>> saveDistricts(DistrictDTO districts, URI uri) throws IOException{
        DistrictRepository.serializeDistricts(districts.getDistricts());
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        response.put("message", "Bairros cadastrados com sucesso");
        return ResponseEntity.created(uri).body(response);
    }


    /**
     * Retorna lista de bairros desserializados
     *
     * @author Thomaz Ferreira
     * @return ResponseEntity
     */
    public ResponseEntity<DistrictDTO> getAllDistricts() throws IOException {
        List<District> unserializedDistrics = DistrictRepository.unserializeDistricts();
        DistrictDTO dto = DistrictDTO.parseToListDTO(unserializedDistrics);
        return ResponseEntity.ok().body(dto);
    }
}
