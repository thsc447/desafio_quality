package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.entity.Room;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertyControllerTest {

    //prop_name;
    @Test
    public void shouldntAllowEmptyNames() {
        // "O nome da propriedade não pode estar vazio.")
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
