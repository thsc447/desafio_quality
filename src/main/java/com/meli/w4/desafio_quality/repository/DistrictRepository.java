package com.meli.w4.desafio_quality.repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.w4.desafio_quality.entity.District;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DistrictRepository {

    private static final String JSON_FILE_NAME = "bairros.json";


    public static void serializeDistricts(List<District> districts) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(JSON_FILE_NAME), districts);
        } catch (IOException e) {
            throw new RuntimeException("Falha na leitura ou escrita do arquivo");
        }
    }


    public static List<District> unserializeDistricts() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<District> listaBairros = new ArrayList<District>();
        try {
            File file = new File(JSON_FILE_NAME);
            if (file.exists()) {
                listaBairros = mapper.readValue(file,
                        mapper.getTypeFactory().constructCollectionType(
                                List.class, District.class));
            }
        } catch (IOException e) {
            throw new RuntimeException("Falha na leitura ou escrita do arquivo");
        }
        return listaBairros;
    }
}
