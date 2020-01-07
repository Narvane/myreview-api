package br.com.myreview.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.myreview.model.Establishment;
import br.com.myreview.repository.UserRepository;

public class EstablishmentService {
	@Autowired
	private UserRepository userRepository; 
	
	public Establishment addEstablishment(Establishment establishment){
		establishment.getReviews().forEach(i -> {
			i.setEstablishment(establishment);
			i.setUser(userRepository.findById(i.getUser().getId()).get());
		});
		return establishment;
	}
}
