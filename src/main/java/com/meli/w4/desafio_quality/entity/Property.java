package com.meli.w4.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private String prop_name;
    @NotBlank(message = "O Nome da propriedade não pode estar vazio.")
    @Length(min = 1 , max = 30 , message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_district;
    private BigDecimal value_district_m2;
    private List<Room> rooms;
}
