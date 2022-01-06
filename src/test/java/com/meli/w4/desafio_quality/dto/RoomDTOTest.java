package com.meli.w4.desafio_quality.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.meli.w4.desafio_quality.entity.Room;

public class RoomDTOTest {

	private RoomDTO roomDTO;
	private List<Room> listRoom = new ArrayList<>();
	private List<RoomDTO> listRoomDTO = new ArrayList<>();

	@Before
	public void setup() {
	}

	@Test
	void shouldBeAbleToConvertfromEntityToDTO() {
		roomDTO = RoomDTO.convert(
				Room.builder().room_name("R1").room_length(2d).room_width(2d).build());
		assertEquals(4d, roomDTO.getArea());
		assertEquals("R1", roomDTO.getRoom_name());
	}

	@Test
	void shouldBeAbleToConvertfromListOfEntitiesToListOfDTO() {
		Room room1 = Room.builder().room_name("R1").room_length(1d).room_width(1d).build();
		Room room2 = Room.builder().room_name("R2").room_length(2d).room_width(2d).build();
		listRoom.add(room1);
		listRoom.add(room2);

		listRoomDTO = RoomDTO.convertList(listRoom);

		assertEquals(2, listRoomDTO.size());
		assertEquals("R1", listRoomDTO.get(0).getRoom_name());
	}
}
