package com.sample.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.model.Country;
import com.sample.repository.CountryRepository;
import com.sample.service.CountryService;


@Tag("dev")
@SpringBootTest(classes=CountryServiceTest.class)
public class CountryServiceTest {

	@Mock
	CountryRepository countryRepository;
	@InjectMocks
	CountryService countryService;

	@Order(1)
	@Test
	public void getAllCountries() {
		List<Country> countryList = new ArrayList<Country>();
		countryList.add(new Country(1, "aaa", "bbb"));
		countryList.add(new Country(2, "ddd", "ccc"));
		when(countryRepository.findAll()).thenReturn(countryList);// mocking external dependepency
		assertEquals(2, countryService.getAllCountries().size());
	}

	@Order(2)
	@Test
	public void addCountry() {
		Country country = new Country(1004, "qqqq", "rrr");
		when(countryRepository.save(country)).thenReturn(country);
		assertEquals(country, countryService.addCountry(country));
	}
}