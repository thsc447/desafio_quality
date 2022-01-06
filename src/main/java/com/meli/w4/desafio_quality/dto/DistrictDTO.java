package com.meli.w4.desafio_quality.dto;

import com.meli.w4.desafio_quality.entity.District;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {

    @NotEmpty(message = "A lista não pode estar vazia")
    private List<@Valid District> districts;


    /**
     * Converte obejto para DTO
     *
     * @author Thomaz Ferreira
     * @param districts
     * @return DistrictDTO
     */
    public static DistrictDTO parseToDTO(List<District> districts){
        return DistrictDTO.builder().districts(districts).build();
    }
}