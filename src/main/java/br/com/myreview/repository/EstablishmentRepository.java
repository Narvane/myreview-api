package br.com.myreview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.myreview.model.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
	List<Establishment> findByOrderByStarsDesc();
	
	@Query("SELECT e FROM Establishment e JOIN e.district d JOIN d.city c JOIN c.state s WHERE s.name = :stateName ORDER BY e.stars DESC") 
	List<Establishment> findByStateOrderByStarsDesc(@Param("stateName") String stateName);
	
	@Query("SELECT e FROM Establishment e JOIN e.district d JOIN d.city c WHERE c.name = :cityName ORDER BY e.stars DESC")  
	List<Establishment> findByCityOrderByStarsDesc(@Param("cityName") String cityName);
	
	@Query("SELECT e FROM Establishment e JOIN e.district d WHERE d.name = :districtName ORDER BY e.stars DESC") 
	List<Establishment> findByDistrictOrderByStarsDesc(@Param("districtName") String districtName);
	 
}
