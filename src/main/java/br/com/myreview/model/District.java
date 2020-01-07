package br.com.myreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="dst_districts")
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dst_id")
	private Long id;
	
	@Column(name = "dst_name", nullable = false)
	private String name;
	
	@JsonIgnore
	@JoinColumn(name="cty_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private City city;
	
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	
	

}
