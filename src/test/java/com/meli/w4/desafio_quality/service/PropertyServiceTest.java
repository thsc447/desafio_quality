package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.RoomDTO;
import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyServiceTest {

    //calculateAreaTotal
    @Test
    public void shouldReturnTotalAreaInPropertyResponse() {
        List<Property> properties = ListOfProperty();
        PropertyResponse result = makeSUT().calculateAreaTotal(properties.get(0));
        assertEquals(5, result.getTotalArea());
        assertEquals(new BigDecimal(10).setScale(1), result.getPrice());
        assertEquals("1", result.getBiggestRoom());
    }

    //calculateAreaByRoom
    @Test
    public void shouldCalculateAreaByRoom() {
        List<Property> properties = ListOfProperty();
        List result = makeSUT().calculateAreaByRoom(properties.get(0));
        assertEquals(RoomDTO.convertList(ListOfRooms()), result);
    }

    //getBiggestRoom
    @Test
    public void shouldReturnTheBiggestRoom() {
        List<Property> properties = ListOfProperty();
        List result = makeSUT().calculateAreaByRoom(properties.get(0));
        assertEquals(RoomDTO.convertList(ListOfRooms()), result);
    }

    //getPropetyArea
    @Test
    public void shouldGetBiggestRoom() {
        Property property = ListOfProperty().get(0);
        String result = makeSUT().getBiggestRoom(property);
        assertEquals("1", result);
    }

    //calculateTotalArea
    @Test
    public void shouldReturnTheTotalArea() {
        List<Room> rooms = ListOfRooms();
        Double result = makeSUT().calculateTotalArea(rooms);
        assertEquals(5, result);
    }

    //calculateTotalPriceOfProperty
    @Test
    public void shouldReturnTheTotalValueOfTheProperty() {
        Property property = ListOfProperty().get(0);
        BigDecimal result = makeSUT().calculateTotalPriceOfProperty(property);
        assertEquals(new BigDecimal(10).setScale(1), result);
    }

    private PropertyService makeSUT() {
        List<Property> property = ListOfProperty();
        PropertyRepository mock = Mockito.mock(PropertyRepository.class);
        Mockito.when(mock.save(property)).thenReturn(property);
        PropertyService propertyService = new PropertyService(mock);
        return propertyService;
    }

    private List<Property> ListOfProperty() {
        List<Property> properties = Arrays.asList(
                Property.builder()
                        .prop_name("1")
                        .prop_district("test")
                        .value_district_m2(BigDecimal.valueOf(2))
                        .rooms(ListOfRooms())
                        .build()
        );
        return properties;
    }

    private List<Room> ListOfRooms() {
        List<Room> rooms = Arrays.asList(
                Room.builder()
                        .room_name("1")
                        .room_width(2d)
                        .room_length(2d)
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