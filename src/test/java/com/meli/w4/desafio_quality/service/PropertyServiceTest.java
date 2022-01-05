package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import com.meli.w4.desafio_quality.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
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

    @Test
    public void shouldReturnTheTotalValueOfTheProperty(){
        Property property = ListOfProperty().get(0);
        BigDecimal result = makeSUT().calculateTotalPriceOfProperty(property);
        assertEquals(new BigDecimal(2).setScale(1), result);
    }

    private PropertyService makeSUT(){
        List<Property> property = ListOfProperty();
        PropertyRepository mock = Mockito.mock(PropertyRepository.class);
        Mockito.when(mock.save(property)).thenReturn(property);
        PropertyService propertyService = new PropertyService(mock);
        return propertyService;
    }

    private List<Property> ListOfProperty(){
        List<Property> properties = Arrays.asList(
                Property.builder()
                        .prop_name("1")
                        .prop_district("test")
                        .value_district_m2(BigDecimal.valueOf(1))
                        .rooms(ListOfRooms())
                        .build()
        );
        return properties;
    }

    private List<Room> ListOfRooms(){
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