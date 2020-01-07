package br.com.myreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.myreview.model.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
	@Query("SELECT d FROM District d JOIN d.city c WHERE c.name = :cityName GROUP BY d.name") 
	List<District> findDistrictsByCity(@Param("cityName") String cityName);
}
