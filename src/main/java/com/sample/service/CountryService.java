package com.sample.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sample.model.AddResponse;
import com.sample.model.Country;
import com.sample.repository.CountryRepository;

@Service
@Component
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAllCountries() {
		System.out.print("entering into service");
		return countryRepository.findAll();
	}

	public Country addCountry(Country country) {
		country.setId(getmaxId());
		return countryRepository.save(country);
	}

	public int getmaxId() {
		return countryRepository.findAll().size() + 1;
	}

}

