package com.meli.w4.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z].*$", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;
    @NotEmpty(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;
    @NotNull(message = "O valor do metro quadrado não pode estar vazio.")
    @Digits(integer = 13, fraction = 2, message = "O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos decimais.")
    private BigDecimal value_district_m2;
    @NotEmpty(message = "A lista de cômodos não pode estar vazia.")
    private List<@Valid Room> rooms;
}
