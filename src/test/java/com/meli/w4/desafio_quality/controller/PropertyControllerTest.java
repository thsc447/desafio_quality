package com.meli.w4.desafio_quality.controller;

import com.meli.w4.desafio_quality.dto.DistrictDTO;
import com.meli.w4.desafio_quality.entity.District;
import com.meli.w4.desafio_quality.service.DistrictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldBeSuccessful() throws Exception {
		DistrictService districtService = new DistrictService();
		List<District> districts = Arrays.asList(new District("Teste"));
		districtService.saveDistricts(DistrictDTO.builder().districts(districts).build());
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Teste\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room 1\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void shouldNotAcceptEmptyPropName() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room 1\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O nome da propriedade não pode estar vazio.")));
	}

	@Test
	public void shouldNotAcceptNullPropName() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room 1\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O nome da propriedade não pode estar vazio.")));
	}

	@Test
	public void shouldNotAcceptPropNameBiggerThan30() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"A..............................\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room 1\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O comprimento do nome não pode exceder 30 caracteres.")));
	}

	@Test
	public void shouldNotAcceptPropNameNotStartingCapital() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"aaaaa\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room 1\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O nome da propriedade deve começar com uma letra maiúscula.")));
	}

	@Test
	public void shouldNotAcceptUnregisteredNeighborhoods() throws Exception {
		// "Bairro informado não existe na lista de bairros cadastrados")
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room 1\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertEquals("Bairro informado não existe na lista de bairros cadastrados",
						result.getResolvedException()
								.getMessage()));
	}

	// prop_district;
	@Test
	public void shouldntAcceptNullDistrict() throws Exception {
		// O bairro não pode estar vazio.
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"value_district_m2\": 10,\n" +
				"    \"rooms\": [\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 15,\n" +
				"            \"room_name\": \"Room1\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 30,\n" +
				"            \"room_name\": \"Room2\"\n" +
				"        },\n" +
				"                {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 33,\n" +
				"            \"room_name\": \"Room3\"\n" +
				"        }\n" +
				"    ]\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O bairro não pode estar vazio.")));

	}

	@Test
	public void shouldntAcceptEmptyDistrict() throws Exception {
		// O bairro não pode estar vazio.
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"prop_district\": \"\",\n" +
				"    \"value_district_m2\": 10,\n" +
				"    \"rooms\": [\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 15,\n" +
				"            \"room_name\": \"Room1\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 30,\n" +
				"            \"room_name\": \"Room2\"\n" +
				"        },\n" +
				"                {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 33,\n" +
				"            \"room_name\": \"Room3\"\n" +
				"        }\n" +
				"    ]\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O bairro não pode estar vazio.")));
	}

	@Test
	public void shouldntAcceptNeighborhoodNamesBiggerThan45Characters() throws Exception {
		// "O comprimento do bairro não pode exceder 45 caracteres.")
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"prop_district\": \"Testeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee\",\n" +
				"    \"value_district_m2\": 10,\n" +
				"    \"rooms\": [\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 15,\n" +
				"            \"room_name\": \"Room1\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 30,\n" +
				"            \"room_name\": \"Room2\"\n" +
				"        },\n" +
				"                {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 33,\n" +
				"            \"room_name\": \"Room3\"\n" +
				"        }\n" +
				"    ]\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O comprimento do bairro não pode exceder 45 caracteres.")));

	}

	@Test
	public void shouldntAcceptDistrictM2ValueGreaterThan13Digits() throws Exception {
		// "O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos
		// decimais.")
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"prop_district\": \"Teste\",\n" +
				"    \"value_district_m2\": 100000000000000000,\n" +
				"    \"rooms\": [\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 15,\n" +
				"            \"room_name\": \"Room1\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 30,\n" +
				"            \"room_name\": \"Room2\"\n" +
				"        },\n" +
				"                {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 33,\n" +
				"            \"room_name\": \"Room3\"\n" +
				"        }\n" +
				"    ]\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains(
								"O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos decimais.")));
	}

	@Test
	public void shouldntAcceptDistrictM2ValueGreaterThan2Decimals() throws Exception {
		// "O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos
		// decimais.")
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"prop_district\": \"Teste\",\n" +
				"    \"value_district_m2\": 1.234,\n" +
				"    \"rooms\": [\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 15,\n" +
				"            \"room_name\": \"Room1\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 30,\n" +
				"            \"room_name\": \"Room2\"\n" +
				"        },\n" +
				"                {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 33,\n" +
				"            \"room_name\": \"Room3\"\n" +
				"        }\n" +
				"    ]\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains(
								"O valor do metro quadrado não pode exceder 13 dígitos inteiros nem 2 dígitos decimais.")));
	}

	@Test
	public void shouldntAcceptNullDistrictM2Value() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"prop_district\": \"Teste\",\n" +
				"    \"rooms\": [\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 15,\n" +
				"            \"room_name\": \"Room1\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 30,\n" +
				"            \"room_name\": \"Room2\"\n" +
				"        },\n" +
				"                {\n" +
				"            \"room_width\": 10,\n" +
				"            \"room_length\": 33,\n" +
				"            \"room_name\": \"Room3\"\n" +
				"        }\n" +
				"    ]\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains(
								"O valor do metro quadrado não pode estar vazio")));
	}

	// rooms
	@Test
	public void shouldntAcceptAnEmptyRoomsList() throws Exception {
		// "A lista de cômodos não pode estar vazia.
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"prop_district\": \"Teste\",\n" +
				"    \"value_district_m2\": 10,\n" +
				"    \"rooms\": [\n" +
				"    ]\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("A lista de cômodos não pode estar vazia.")));
	}

	@Test
	public void shouldntAcceptANullLRoomsList() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\": \"Propriedade\",\n" +
				"    \"prop_district\": \"Teste\",\n" +
				"    \"value_district_m2\": 10\n" +
				"} ";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("A lista de cômodos não pode estar vazia.")));
	}

	@Test
	public void shouldNotAcceptEmptyRoomName() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O nome do cômodo não pode estar vazio.")));
	}

	@Test
	public void shouldNotAcceptRoomNameNotStartingCapital() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Rooooooooooooooooooooooooooooom\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O comprimento do nome do cômodo não pode exceder 30 caracteres")));
	}

	@Test
	public void shouldNotAcceptRoomNameBiggerThan30() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"room1\",\n" +
				"            \"room_width\": 10.0,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O nome do cômodo deve começar com uma letra maiúscula.")));
	}

	@Test
	public void shouldNotAcceptNullRoomWidth() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room1\",\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("A largura do cômodo não pode estar vazia.")));
	}

	@Test
	public void shouldNotAcceptRoomWidthBiggerThan25() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room1\",\n" +
				"            \"room_width\": 25.1,\n" +
				"            \"room_length\": 10.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("A largura máxima permitida por cômodo é de 25 metros.")));
	}

	@Test
	public void shouldNotAcceptNullRoomLength() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room1\",\n" +
				"            \"room_length\": 10.0,\n" +
				"            \"room_width\": 20.0\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O comprimento do cômodo não pode estar vazio.")));
	}

	@Test
	public void shouldNotAcceptRoomLengthBiggerThan33() throws Exception {
		URI uri = new URI("/property/area");
		String json = "{\n" +
				"    \"prop_name\":\"Property Name\",\n" +
				"    \"prop_district\":\"Property District\",\n" +
				"    \"value_district_m2\":100,\n" +
				"    \"rooms\":\n" +
				"    [\n" +
				"        {\n" +
				"            \"room_name\": \"Room1\",\n" +
				"            \"room_width\": 25.0,\n" +
				"            \"room_length\": 33.1\n" +
				"        },\n" +
				"        {\n" +
				"            \"room_name\": \"Room 2\",\n" +
				"            \"room_width\": 20.0,\n" +
				"            \"room_length\": 30.0\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(result -> assertTrue(result.getResolvedException()
						.getMessage().contains("O comprimento máximo permitido por cômodo é de 33 metros.")));
	}
}
