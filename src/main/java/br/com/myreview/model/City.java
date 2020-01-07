package br.com.myreview.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cty_citys")
public class City{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cty_id")
	private Long id;
	
	@Column(name = "cty_name", nullable = false)
	private String name;
	
	@JsonIgnore
	@JoinColumn(name="sts_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private State state;
	
	@JsonIgnore
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	private List<District> districts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
	
	
}
