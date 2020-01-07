package br.com.myreview.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="est_establishments")
public class Establishment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "est_id")
	private Long id;
	
	@Column(name = "est_name", length = 50, nullable = false)
	@NotEmpty
	private String name;
	
	@Column(name = "est_cnpj", length = 14, nullable = false)
	@NotEmpty
	private String cnpj;
	
	@Column(name = "est_description", length = 300, nullable = true)
	private String description = "Sem descrição!";
	
	@Column(name = "est_stars", nullable = false)
	private Double stars = 0.0;
	
	@JoinColumn(name="dst_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private District district;
	
	@Column(name = "est_number", length = 100, nullable = false)
	@Min(0)
	private int number;
	
	@OneToMany(mappedBy = "establishment", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Review> reviews;
	
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getStars() {
		return stars;
	}
	public void setStars(Double stars) {
		this.stars = stars;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	
	
}
