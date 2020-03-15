package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Model for Person
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="people")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	private String known_for_department;
	
	private Integer id;
	
	private String name;
	
	private String biography;
	
	private Integer popularity;
	
	private String place_of_birth;
	
	private String profile_path;
	
	@ElementCollection
	private List<ResultMovie> cast;
	
	
	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getKnown_for_department() {
		return known_for_department;
	}


	public void setKnown_for_department(String known_for_department) {
		this.known_for_department = known_for_department;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBiography() {
		return biography;
	}


	public void setBiography(String biography) {
		this.biography = biography;
	}


	public Integer getPopularity() {
		return popularity;
	}


	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}


	public String getPlace_of_birth() {
		return place_of_birth;
	}


	public void setPlace_of_birth(String place_of_birth) {
		this.place_of_birth = place_of_birth;
	}


	public String getProfile_path() {
		return profile_path;
	}


	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	

	public List<ResultMovie> getCast() {
		return cast;
	}


	public void setCast(List<ResultMovie> cast) {
		this.cast = cast;
	}



	private static final long serialVersionUID = 1L;

}
