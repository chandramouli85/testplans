package com.sample.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sample.controller.CountryController;
import com.sample.model.Country;
import com.sample.service.CountryService;

@Tag("dev")
@SpringBootTest(classes = {CountryControllerTest.class})
public class CountryControllerTest {

	@Mock
	CountryService countryService;
	@InjectMocks
	CountryController countryController;
	List<Country> myCountries;
	Country country;

	@Test
	void getAllContries() {
		myCountries = new ArrayList<Country>();
		myCountries.add(new Country(1, "india", "delhi"));
		myCountries.add(new Country(2, "canada", "xyx"));
		when(countryService.getAllCountries()).thenReturn(myCountries);
		ResponseEntity<List<Country>> res = countryController.getAllContries();
		assertEquals(HttpStatus.FOUND, res.getStatusCode().FOUND);
		assertEquals(2, res.getBody().size());
	}

	@Test
	void addCountry() {
		country = new Country(1, "india", "delhi");
		when(countryService.addCountry(country)).thenReturn(country);
		ResponseEntity<Country> response = countryController.addCountry(country);
		assertEquals(HttpStatus.CREATED, response.getStatusCode().CREATED);
		assertEquals(country, response.getBody());
	}
}