package br.com.myreview.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import br.com.myreview.model.Establishment;

import br.com.myreview.repository.EstablishmentRepository;


@CrossOrigin
@RestController
@RequestMapping("/establishments")
public class EstablishmentController {
	
	@Autowired
	private EstablishmentRepository establishmentRepository;
	
	
	@PostMapping
	public Establishment saveEstablishment(@Valid @RequestBody Establishment establishment) {
		Optional<Establishment> registredEstablishments = establishmentRepository.findById(establishment.getId());
		
		if(registredEstablishments.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já exixste um restaurante neste email ou CNPJ!");
		}
		return establishmentRepository.save(establishment);
	}
	
	@GetMapping("/{id}")
	public Establishment getEstablishment(@PathVariable(name="id") Long id) {
		Optional<Establishment>  establishment;
		establishment = establishmentRepository.findById(id);
		
		if(!establishment.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este estabelecimento não existe!");
		}
		
		return establishment.get();
	}
	
	
	@GetMapping("/all")
	public List<Establishment> getEstablishments() {
		List<Establishment> estabList;
		estabList = establishmentRepository.findByOrderByStarsDesc();
		return estabList;
	}
	
	@GetMapping("/state/{stateName}")
	public ResponseEntity<List<Establishment>> getEstablishmentsByState(@PathVariable(name="stateName") String stateName) {
		List<Establishment> estabStateList;
		estabStateList = establishmentRepository.findByStateOrderByStarsDesc(stateName);

		if(estabStateList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(estabStateList);
	}
	
	@GetMapping("/city/{cityName}")
	public ResponseEntity<List<Establishment>> getEstablishmentsByCity(@PathVariable(name="cityName") String cityName) {
		List<Establishment> estabStateCityList;
		estabStateCityList = establishmentRepository.findByCityOrderByStarsDesc(cityName);
		
		if(estabStateCityList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estabStateCityList);
	}
	
	@GetMapping("/district/{districtName}")
	public ResponseEntity<List<Establishment>> getEstablishmentsByDistrict(@PathVariable(name="districtName") String districtName) {
		List<Establishment> estabStateCityDistrictList;
		estabStateCityDistrictList = establishmentRepository.findByDistrictOrderByStarsDesc(districtName);
		
		if(estabStateCityDistrictList.isEmpty()) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estabStateCityDistrictList);
	}
}
