package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Episode
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="episodes")
public class Episode implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Date air_date;
	
	private Integer episode_number;
	
	private Integer show_id;
	
	private String name;
	
	private String overview;
	
	private Integer season_number;
	
	private String still_path;
	
	private Integer vote_average;
	
	private Integer vote_count;
	
	public Date getAir_date() {
		return air_date;
	}



	public void setAir_date(Date air_date) {
		this.air_date = air_date;
	}



	public Integer getEpisode_number() {
		return episode_number;
	}



	public void setEpisode_number(Integer episode_number) {
		this.episode_number = episode_number;
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



	public Integer getSeason_number() {
		return season_number;
	}



	public void setSeason_number(Integer season_number) {
		this.season_number = season_number;
	}



	public Integer getShow_id() {
		return show_id;
	}



	public void setShow_id(Integer show_id) {
		this.show_id = show_id;
	}



	public String getStill_path() {
		return still_path;
	}



	public void setStill_path(String still_path) {
		this.still_path = still_path;
	}



	public Integer getVote_average() {
		return vote_average;
	}



	public void setVote_average(Integer vote_average) {
		this.vote_average = vote_average;
	}



	public Integer getVote_count() {
		return vote_count;
	}



	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}



	private static final long serialVersionUID = 1L;
}
