package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //prop_name;
    @Test
    public void shouldntAllowEmptyNames() throws Exception {
        // "O nome da propriedade não pode estar vazio.")
        URI uri = new URI("/property/area");
        String json = "{\"prop_name\":\"a\",\"prop_district\":\"PropertyDistrict\",\"value_district_m2\":100,\"rooms\":[{\"room_name\":\"Room1\",\"room_width\":10.0,\"room_length\":10.0},{\"room_name\":\"Room2\",\"room_width\":20.0,\"room_length\":30.0}]}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(40));
    }

    public void shouldntAllowNullNames() {
        // "O nome da propriedade não pode estar vazio.")
    }

    public void shouldntAcceptNamesLongerThan30Characters() {
        // "O comprimento do nome não pode exceder 30 caracteres")
    }

    public void shouldntAcceptNamesStartingWithLowerCaseLetters() {
        // "O nome da propriedade deve começar com uma letra maiúscula.")
    }

    //prop_district;
    public void shouldntAcceptNullDistricts() {
        // O bairro não pode estar vazio.")

    }

    public void shouldntAcceptEmptyDistricts() {
        // O bairro não pode estar vazio.")

    }

    public void shouldntAcceptNeighborhoodNamesBiggerThen45Characters() {
        //"O comprimento do bairro não pode exceder 45 caracteres.")

    }

    //value_district_m2;
    public void shouldntAcceptTheNullValue() {
        //"O valor do metro quadrado não pode estar vazio."

    }

    public void shouldntAcceptTheEmptyValue() {
        //"O valor do metro quadrado não pode estar vazio."

    }

    public void shouldntAcceptValuesGreaterThan13Digits() {
        //"O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos decimais.")

    }

    //rooms
    public void shouldntAcceptAnEmptyList() {
        //"A lista de cômodos não pode estar vazia.")

    }

    public void shouldntAcceptAnNullList() {
        //"A lista de cômodos não pode estar vazia.")

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
