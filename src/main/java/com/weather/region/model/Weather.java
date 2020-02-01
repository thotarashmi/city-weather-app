package com.weather.region.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.Data;

@Data
@Entity
@Table(name = "weather")
public class Weather   extends Auditable<String> implements Serializable  {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "temperature")
	String temperature;

	@Column(name = "wind")
	String wind;

	@Column(name = "humidity")
	Integer humidity;

	@Column(name = "airQuality")
	String airQuality;

	@Column(name = "airQualityIndex")
	Integer airQualityIndex;

	@Column(name = "sunrise")
	private Instant sunrise;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
	

}
