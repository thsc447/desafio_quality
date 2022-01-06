package com.meli.w4.desafio_quality.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DistrictControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sucessOnRegisterDistricts() throws Exception{
        URI endpoint = new URI("/registerDistrict");
        String payload = "{\n" +
                "    \"districts\": [\n" +
                "        {\n" +
                "            \"name\": \"xpto\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"xpto\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"xpto\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post(endpoint).content(payload).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andExpect(result -> assertEquals("{\"message\":\"Bairros cadastrados com sucesso\",\"status\":\"success\"}", result.getResponse().getContentAsString()));
    }
}
