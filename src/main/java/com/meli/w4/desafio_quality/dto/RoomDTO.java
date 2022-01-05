package com.meli.w4.desafio_quality.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO implements Comparable<RoomDTO> {
    private String room_name;
    private Double area;


    @Override
    public int compareTo(RoomDTO o) {
        if (this.area > o.getArea()) {
            return 1;
        } else if (this.area < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
