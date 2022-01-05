package com.meli.w4.desafio_quality.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //prop_name;
    @Test
    public void shouldntAllowEmptyNames() throws Exception {
        // "O nome da propriedade não pode estar vazio.")
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/property/area"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
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

    public void shouldntAcceptValuesGreaterThan13Digits(){
        //"O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos decimais.")

    }

    //rooms
    public void shouldntAcceptAnEmptyList(){
        //"A lista de cômodos não pode estar vazia.")

    }

    public void shouldntAcceptAnNullList(){
        //"A lista de cômodos não pode estar vazia.")

    }
}
