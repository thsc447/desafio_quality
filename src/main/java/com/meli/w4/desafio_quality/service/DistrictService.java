package com.meli.w4.desafio_quality.service;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

	public void saveDistricts(DistrictDTO districts) {
		DistrictRepository.serializeDistricts(districts.getDistricts());
	}


	public DistrictDTO getAllDistricts() {
		List<District> unserializedDistrics = DistrictRepository.unserializeDistricts();
		return DistrictDTO.parseToDTO(unserializedDistrics);
	}
}
