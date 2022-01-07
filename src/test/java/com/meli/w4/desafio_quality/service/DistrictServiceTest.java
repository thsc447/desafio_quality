package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.entity.District;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DistrictServiceTest {

	@Test
	public void deveRetornarUmaExceptionQuandoUmJSONIndevidoForEncaminhado(){
		DistrictService districtService = new DistrictService();
		assertNotNull(districtService.getAllDistricts());
	}

	@Test
	public void deveRetornarOBaiiroTeste(){
		DistrictService districtService = new DistrictService();
		List<District> compare = Arrays.asList(District.builder().name("Teste").build());
		assertArrayEquals(compare.toArray() ,districtService.getAllDistricts().getDistricts().toArray());
	}

}
