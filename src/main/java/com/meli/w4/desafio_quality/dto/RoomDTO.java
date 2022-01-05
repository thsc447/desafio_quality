package com.meli.w4.desafio_quality.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.meli.w4.desafio_quality.entity.Room;

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

    public static RoomDTO convert(Room r) {
        return RoomDTO.builder()
                .area(r.getRoom_length() * r.getRoom_width())
                .room_name(r.getRoom_name())
                .build();
    }

    public static List<RoomDTO> convertList(List<Room> rs) {
        return rs.stream()
                .map(RoomDTO::convert)
                .collect(Collectors.toList());
    }

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
