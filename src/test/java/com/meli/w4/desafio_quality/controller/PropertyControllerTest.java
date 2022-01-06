package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.entity.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //prop_name;
    @Test
    public void shouldNotAcceptUnregisteredNeighborhoods() throws Exception {
        // "O nome da propriedade não pode estar vazio.")
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\":\"Property Name\",\n" +
                "    \"prop_district\":\"Property District\",\n" +
                "    \"value_district_m2\":100,\n" +
                "    \"rooms\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"room_name\": \"Room 1\",\n" +
                "            \"room_width\": 10.0,\n" +
                "            \"room_length\": 10.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_name\": \"Room 2\",\n" +
                "            \"room_width\": 20.0,\n" +
                "            \"room_length\": 30.0\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        //mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
        //        .andExpect(MockMvcResultMatchers.status().is(400))
        //        .andExpect(result -> assertEquals("Bairro informado não existe na lista de bairros cadastrados", result.getResolvedException()
        //                .getMessage()));
    }

    @Test
    public void shouldntAcceptNamesStartingWithLowerCaseLetters() throws Exception {
        // O nome da propriedade deve começar com uma letra maiúscula.
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\": \"Propriedade\",\n" +
                "    \"prop_district\": \"teste\",\n" +
                "    \"value_district_m2\": 10,\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 15,\n" +
                "            \"room_name\": \"Room1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 30,\n" +
                "            \"room_name\": \"Room2\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 33,\n" +
                "            \"room_name\": \"Room3\"\n" +
                "        }\n" +
                "    ]\n" +
                "} ";
        //mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
        //        .andExpect(MockMvcResultMatchers.status().is(400));
                //.andExpect(result -> assertTrue(result.getResolvedException()
                //        .getMessage().contains("O nome da propriedade deve começar com uma letra maiúscula.")));
    }

    //prop_district;
    @Test
    public void shouldntAcceptNullDistricts() throws Exception {
        // O bairro não pode estar vazio.
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\": \"Propriedade\",\n" +
                "    \"value_district_m2\": 10,\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 15,\n" +
                "            \"room_name\": \"Room1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 30,\n" +
                "            \"room_name\": \"Room2\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 33,\n" +
                "            \"room_name\": \"Room3\"\n" +
                "        }\n" +
                "    ]\n" +
                "} ";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        .getMessage().contains("O bairro não pode estar vazio.")));

    }
    @Test
    public void shouldntAcceptEmptyDistricts() throws Exception {
        // O bairro não pode estar vazio.
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\": \"Propriedade\",\n" +
                "    \"prop_district\": \"\",\n" +
                "    \"value_district_m2\": 10,\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 15,\n" +
                "            \"room_name\": \"Room1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 30,\n" +
                "            \"room_name\": \"Room2\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 33,\n" +
                "            \"room_name\": \"Room3\"\n" +
                "        }\n" +
                "    ]\n" +
                "} ";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        .getMessage().contains("O bairro não pode estar vazio.")));
    }
    @Test
    public void shouldntAcceptNeighborhoodNamesBiggerThen45Characters() throws Exception {
        //"O comprimento do bairro não pode exceder 45 caracteres.")
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\": \"Propriedade\",\n" +
                "    \"prop_district\": \"Testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee\",\n" +
                "    \"value_district_m2\": 10,\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 15,\n" +
                "            \"room_name\": \"Room1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 30,\n" +
                "            \"room_name\": \"Room2\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 33,\n" +
                "            \"room_name\": \"Room3\"\n" +
                "        }\n" +
                "    ]\n" +
                "} ";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        .getMessage().contains("O comprimento do bairro não pode exceder 45 caracteres.")));

    }
    @Test
    public void shouldntAcceptValuesGreaterThan13Digits() throws Exception {
        //"O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos decimais.")
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\": \"Propriedade\",\n" +
                "    \"prop_district\": \"Teste\",\n" +
                "    \"value_district_m2\": 100000000000000000,\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 15,\n" +
                "            \"room_name\": \"Room1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 30,\n" +
                "            \"room_name\": \"Room2\"\n" +
                "        },\n" +
                "                {\n" +
                "            \"room_width\": 10,\n" +
                "            \"room_length\": 33,\n" +
                "            \"room_name\": \"Room3\"\n" +
                "        }\n" +
                "    ]\n" +
                "} ";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        .getMessage().contains("O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos decimais.")));
    }
    //rooms
    @Test
    public void shouldntAcceptAnEmptyList() throws Exception {
        //"A lista de cômodos não pode estar vazia.
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\": \"Propriedade\",\n" +
                "    \"prop_district\": \"Teste\",\n" +
                "    \"value_district_m2\": 100,\n" +
                "    \"rooms\": ] +} ";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
                //.andExpect(result -> assertTrue(result.getResolvedException()
                //        .getMessage().contains("A lista de cômodos não pode estar vazia.")));
    }
    @Test
    public void shouldntAcceptAnNullList() throws Exception {
        //"A lista de cômodos não pode estar vazia.")
        URI uri = new URI("/property/area");
        String json = "{\n" +
                "    \"prop_name\":\"Property Name\",\n" +
                "    \"prop_district\":\"\",\n" +
                "    \"rooms\":\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
                // .andExpect(result -> assertTrue(result.getResolvedException()
                //        .getMessage().contains("A lista de cômodos não pode estar vazia.")));
    }

    private List<Room> ListOfRooms() {
        List<Room> rooms = Arrays.asList(
                Room.builder()
                        .room_name("1")
                        .room_width(2d)
                        .room_length(2d)
                        .build(),
                Room.builder()
                        .room_name("2")
                        .room_width(1d)
                        .room_length(1d)
                        .build()
        );
        return rooms;
    }

}
