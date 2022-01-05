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


    /**
     * Serializa lista de bairros e armazena em arquivo JSON
     *
     * @author Thomaz Ferreira
     * @param districts
     * @throws IOException
     */
    public static void serializaDistricts(List<District> districts) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(JSON_FILE_NAME), districts);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }


    /**
     * Deserializa lista de bairros em JSON e converte em objeto
     *
     * @author André Arroxellas, Thomaz Ferreira
     * @return List
     * @throws IOException
     */
    public static List<District> desserializaDistricts() throws IOException {
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
            throw new IOException(e.getMessage());
        }
        return listaBairros;
    }
}
