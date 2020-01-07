package br.com.myreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myreview.model.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
