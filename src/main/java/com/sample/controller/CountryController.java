package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.AddResponse;
import com.sample.model.Country;
import com.sample.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/getallCountry")
	public ResponseEntity<List<Country>> getAllContries() {
		try {
			List<Country> countries = countryService.getAllCountries();
			return new ResponseEntity<List<Country>>(countries, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addCountry")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		try {
			country = countryService.addCountry(country);
			return new ResponseEntity<Country>(country, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
