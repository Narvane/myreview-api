package br.com.myreview.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sts_states")
public class State{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sts_id")
	private Long id;
	
	@Column(name = "sts_uf", nullable = false)
	private String uf;
	
	@Column(name = "sts_name", nullable = false)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
	private List<City> cities;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
