package com.weather.region.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name = "city")
public class City extends Auditable<String>  implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Integer cityId;


	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
	private Weather weather;
	
	@Column(name = "city_name")
	String cityName;
	
	@Column(name = "zip_code")
	Integer zipCode;
	
	

}
