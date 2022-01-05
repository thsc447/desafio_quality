package com.meli.w4.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @NotBlank(message = "O Nome da propriedade não pode estar vazio.")
    @NotNull(message ="O nome da propriedade deve começar com uma letra maiúscula..")
    @Length(min = 1 , max = 30 , message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{0,29}$")
    private String prop_name;
    @NotBlank(message = "O bairro não pode estar vazio.")
    @NotNull(message = "O bairro não pode ser nulo,")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
    private String prop_district;
    private BigDecimal value_district_m2;
    private List<Room> rooms;
}
