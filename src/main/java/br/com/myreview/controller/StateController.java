package br.com.myreview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myreview.model.State;
import br.com.myreview.repository.StateRepository;


@CrossOrigin
@RestController
@RequestMapping
public class StateController {
	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping("/states")
	public List<State> getStates() {
		List<State> stateList;
		stateList = stateRepository.findAll();
		
		return stateList;
	}
}
