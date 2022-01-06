package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.dto.RoomDTO;
import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import com.meli.w4.desafio_quality.exception.DistrictFoundException;
import com.meli.w4.desafio_quality.response.PropertyResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyServiceTest {

    PropertyService propertyService = new PropertyService();

    @BeforeAll
    public static void initFile() throws IOException {
        DistrictService districtService = new DistrictService();
        List<District> districts = Arrays.asList(new District("Teste"));
        URI uri = UriComponentsBuilder.fromPath("").build().toUri();
        districtService.saveDistricts(DistrictDTO.builder().districts(districts).build(), uri);
    }

    //calculateAreaTotal
    @Test
    public void shouldReturnTotalAreaInPropertyResponse() throws IOException {
        List<Property> properties = ListOfProperty();
        PropertyResponse result = propertyService.calculateAreaTotal(properties.get(0));
        assertEquals(5, result.getTotalArea());
        assertEquals(new BigDecimal(10).setScale(1), result.getPrice());
        assertEquals("1", result.getBiggestRoom());
    }

    //calculateAreaByRoom
    @Test
    public void shouldCalculateAreaByRoom() {
        List<Property> properties = ListOfProperty();
        List result = propertyService.calculateAreaByRoom(properties.get(0));
        assertEquals(RoomDTO.convertList(ListOfRooms()), result);
    }

    //validateRoomsDTOList
    @Test
    public void shouldCalculateEachRoomArea() {
        List<Property> properties = ListOfProperty();
        List result = propertyService.calculateAreaByRoom(properties.get(0));
        assertEquals(RoomDTO.convertList(ListOfRooms()), result);
    }

    //getBiggestRoom
    @Test
    public void shouldGetBiggestRoom() {
        Property property = ListOfProperty().get(0);
        String result = propertyService.getBiggestRoom(property);
        assertEquals("1", result);
    }

    //calculateTotalArea
    @Test
    public void shouldReturnTheTotalArea() {
        List<Room> rooms = ListOfRooms();
        Double result = propertyService.calculateTotalArea(rooms);
        assertEquals(5, result);
    }

    //calculateTotalPriceOfProperty
    @Test
    public void shouldReturnTheTotalValueOfTheProperty() {
        Property property = ListOfProperty().get(0);
        BigDecimal result = propertyService.calculateTotalPriceOfProperty(property);
        assertEquals(new BigDecimal(10).setScale(1), result);
    }

    //verifyDistrictExist
    @Test
    public void shouldntThrowAnDistrictFoundExceptionWhenProvidedWithAValidDistrict() {
        Property property = ListOfProperty().get(0);
        assertDoesNotThrow(()->propertyService.verifyDistrictExist(property.getProp_district()));
        assertEquals("Teste", property.getProp_district());
    }

    @Test
    public void shouldThrowAnDistrictFoundExceptionWhenProvidedWithAInvalidDistrict() {
        Property property = ListOfProperty().get(0);
        property.setProp_district("prop_invalid");
        assertThrows(DistrictFoundException.class,()->propertyService.verifyDistrictExist(property.getProp_district()));
        assertEquals("prop_invalid", property.getProp_district());
    }

    private List<Property> ListOfProperty() {
        List<Property> properties = Arrays.asList(
                Property.builder()
                        .prop_name("1")
                        .prop_district("Teste")
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
