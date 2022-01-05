package com.meli.w4.desafio_quality.response;

import com.meli.w4.desafio_quality.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyResponse {
    private Double totalArea;
    private BigDecimal price;
    private String biggestRoom;
    private List<RoomDTO> rooms;
}
