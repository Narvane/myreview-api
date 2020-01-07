package br.com.myreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.myreview.model.City;

public interface CityRepository extends JpaRepository<City, Long> {
	@Query("SELECT c FROM City c JOIN c.state s WHERE s.name = :stateName GROUP BY c.name") 
	List<City> findCitiesByStates(@Param("stateName") String stateName);
}
