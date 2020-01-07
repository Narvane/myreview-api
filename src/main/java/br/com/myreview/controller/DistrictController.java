package br.com.myreview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myreview.model.District;
import br.com.myreview.repository.DistrictRepository;

@CrossOrigin
@RestController
@RequestMapping
public class DistrictController {

	@Autowired
	private DistrictRepository districtRepository;
	
	@GetMapping("/districts/{cityName}")
	public List<District> getDistrictsByCity(@PathVariable(name="cityName") String cityName) {
		List<District> districtsList;
		districtsList = districtRepository.findDistrictsByCity(cityName);
		
		return districtsList;
		
	}
}
