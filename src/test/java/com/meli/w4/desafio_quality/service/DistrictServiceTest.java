package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.repository.DistrictRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictServiceTest {

    private DistrictService districtService = new DistrictService();

    @Test
    public void saveDistrictsTest() throws IOException {
        URI uri = UriComponentsBuilder.fromPath("").build().toUri();
        DistrictDTO districtDTO = new DistrictDTO();
        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        response.put("message", "Bairros cadastrados com sucesso");
        Assert.assertEquals(response, districtService.saveDistricts(districtDTO, uri).getBody());
    }


    @Test
    public void getAllDistrictsTest() throws IOException {
        List<District> d = (List<District>) Mockito.when(DistrictRepository.unserializeDistricts()).thenReturn(Arrays.asList(new District()));
        Mockito.when(DistrictDTO.parseToDTO(d)).thenReturn((DistrictDTO) Arrays.asList(new DistrictDTO()));

    }
}
