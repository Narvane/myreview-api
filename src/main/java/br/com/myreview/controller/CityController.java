package br.com.myreview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myreview.model.City;
import br.com.myreview.repository.CityRepository;

@CrossOrigin
@RestController
@RequestMapping
public class CityController {

	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping("/cities/{stateName}")
	public List<City> getCitiesByState(@PathVariable(name="stateName") String stateName) {
		List<City> cityList;
		cityList = cityRepository.findCitiesByStates(stateName);
		
		System.out.println(cityList);
		
		return cityList;
	}
	
}
