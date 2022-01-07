package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DistrictController {

	@Autowired
	DistrictService districtService;


	@PostMapping("/registerDistrict")
	private ResponseEntity<Map<String, String>> registerDistricts(@RequestBody @Valid DistrictDTO districts,
			UriComponentsBuilder uriBuilder) {
		districtService.saveDistricts(districts);
		URI uri = uriBuilder.path("/getDistricts").build().toUri();
		Map<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Bairros cadastrados com sucesso");
		return ResponseEntity.created(uri).body(response);
	}


	@GetMapping("/getDistricts")
	private ResponseEntity<DistrictDTO> getDistricts() {
		DistrictDTO unserializedDistricsDTO = districtService.getAllDistricts();
		return ResponseEntity.ok().body(unserializedDistricsDTO);
	}
}
