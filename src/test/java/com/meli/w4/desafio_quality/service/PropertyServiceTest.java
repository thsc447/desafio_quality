package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyServiceTest {

    @Test
    public void shouldReturnTheTotalArea(){
        List<Room> rooms = ListOfRooms();
        Double result = makeSUT().calculateTotalArea(rooms);
        assertEquals(2,result);
    }

    public PropertyService makeSUT(){
        List<Room> rooms = ListOfRooms();
        PropertyRepository mock = Mockito.mock(PropertyRepository.class);
        Mockito.when(mock.save(rooms)).thenReturn(rooms);
        PropertyService propertyService = new PropertyService(mock);
        return propertyService;
    }

    public List<Room> ListOfRooms(){
        List<Room> rooms = Arrays.asList(
                Room.builder()
                        .room_name("1")
                        .room_width(1d)
                        .room_length(1d)
                        .build(),
                Room.builder()
                        .room_name("2")
                        .room_width(1d)
                        .room_length(1d)
                        .build()
        );
        return rooms;
    }

}