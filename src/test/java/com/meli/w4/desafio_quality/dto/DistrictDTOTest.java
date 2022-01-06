package com.meli.w4.desafio_quality.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.meli.w4.desafio_quality.entity.District;

public class DistrictDTOTest {
	@Test
	void shouldBeAbleToConvertfromListOfEntitiesToListOfDTO() {
		District district1 = District.builder().name("D1").build();
		District district2 = District.builder().name("D2").build();
		List<District> districts = new ArrayList<>();
		DistrictDTO districtsDTO = DistrictDTO.parseToDTO(districts);

		districts.add(district1);
		districts.add(district2);

		assertEquals("D1", districtsDTO.getDistricts().get(0).getName());
	}

	@Test
	void shouldBeAbleToInstanciateNewDistrictDTO() {
		DistrictDTO districtDTO = new DistrictDTO();
		assertInstanceOf(DistrictDTO.class, districtDTO);
	}

}
