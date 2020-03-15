package com.seriesinfo.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Result
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="results")
public class Result implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Integer id;

	private String original_name;
	
	private String poster_path;
	
	private String overview;
	
	private String media_type;
	
	private String backdrop_path;
	
	private String name;
	
	private String title;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBackdrop_path() {
		return backdrop_path;
	}


	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOriginal_name() {
		return original_name;
	}


	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}



	public String getPoster_path() {
		return poster_path;
	}


	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public String getMedia_type() {
		return media_type;
	}


	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}



	private static final long serialVersionUID = 1L;

}
