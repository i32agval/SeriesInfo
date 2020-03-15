package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for SeasonInfo
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="season_infos")
public class SeasonInfo implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;

	private Integer id;
	
	private Date air_date;
	
	private String name;
	
	private String overview;
	
	private String poster_path;
	
	private Integer season_number;
	
	private Integer episode_count;

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getAir_date() {
		return air_date;
	}


	public void setAir_date(Date air_date) {
		this.air_date = air_date;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public String getPoster_path() {
		return poster_path;
	}


	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}


	public Integer getSeason_number() {
		return season_number;
	}


	public void setSeason_number(Integer season_number) {
		this.season_number = season_number;
	}

	

	public Integer getEpisode_count() {
		return episode_count;
	}


	public void setEpisode_count(Integer episode_count) {
		this.episode_count = episode_count;
	}



	private static final long serialVersionUID = 1L;
}
