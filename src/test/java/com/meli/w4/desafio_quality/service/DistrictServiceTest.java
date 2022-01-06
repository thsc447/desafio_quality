package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictServiceTest {

    @Test
    public void saveDistrictsTest() throws IOException {
        DistrictService districtService = new DistrictService();
        URI uri = UriComponentsBuilder.fromPath("").build().toUri();
        DistrictDTO districtDTO = new DistrictDTO();
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        response.put("message", "Bairros cadastrados com sucesso");
        Assert.assertEquals(response, districtService.saveDistricts(districtDTO, uri).getBody());
    }
}
