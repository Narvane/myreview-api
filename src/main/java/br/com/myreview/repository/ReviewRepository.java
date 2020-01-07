package br.com.myreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.myreview.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query("SELECT r FROM Review r JOIN r.establishment e WHERE e.id = :estabId") 
	List<Review> findReviewsByEstablishment(@Param("estabId") Long estabId);
	
	@Query("SELECT r FROM Review r JOIN r.user u WHERE u.id = :userId") 
	List<Review> findReviewsByUser(@Param("userId") Long userId);

}
