package br.com.myreview.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myreview.model.Review;
import br.com.myreview.repository.ReviewRepository;

@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;
	
	
	@PostMapping
	public Review saveReview(@Valid @RequestBody Review review) {
		return reviewRepository.save(review);
	}
	
	@GetMapping("/establishment/{estabId}")
	public List<Review> getReviewsByEstablishment(@PathVariable(name="estabId") Long estabId) {
		List<Review> reviews;
		
		reviews =  reviewRepository.findReviewsByEstablishment(estabId);
		
		return reviews;
	} 
	
	@GetMapping("/user/{userId}")
	public List<Review> getReviewsByUser(@PathVariable(name="userId") Long userId) {
		List<Review> reviews;
		
		reviews =  reviewRepository.findReviewsByUser(userId);
		
		return reviews;
	}
	
}
