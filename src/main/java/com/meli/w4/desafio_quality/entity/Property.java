package com.meli.w4.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private String prop_name;
    @NotBlank(message = "O bairro não pode estar vazio.")
    @NotNull(message = "O bairro não pode ser nulo,")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;
    private BigDecimal value_district_m2;
    private List<Room> rooms;
}
