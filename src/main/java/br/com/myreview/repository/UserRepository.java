package br.com.myreview.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.myreview.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	
	//@Query("SELECT u FROM User u WHERE u.id = :id")
	//Optional<User> findById(@Param("id") Long id);
	
	Optional<User> findByEmailAndPassword(String email, String senha);
}
