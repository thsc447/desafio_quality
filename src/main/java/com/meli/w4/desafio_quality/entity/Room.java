package com.meli.w4.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @NotEmpty(message = "O nome do cômodo não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome do cômodo não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z].*$", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String room_name;
    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Range(max = 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    private Double room_width;
    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Range(max = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros.")
    private Double room_length;
}
