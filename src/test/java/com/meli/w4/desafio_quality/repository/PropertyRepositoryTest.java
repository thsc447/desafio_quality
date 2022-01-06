package com.meli.w4.desafio_quality.repository;

import com.meli.w4.desafio_quality.entity.Property;
import com.meli.w4.desafio_quality.entity.Room;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class PropertyRepositoryTest {

    @Autowired
    PropertyRepository propertyRepository;

    @Test
    public void saveTest() {
        List<Property> property = ListOfProperty();
        //propertyRepository.save(property);
        //assertNotNull(propertyRepository.returnAll());
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
