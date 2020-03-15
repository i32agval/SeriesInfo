package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.seriesinfo.app.entity.SeasonInfo;

/**
 * Model for SeasonDetail
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="season_details")
public class SeasonDetail implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Integer id;
	
	private String name;
	
	private int number_of_episodes;
	
	private int number_of_seasons;
	
	private String overview;
	
	private String poster_path;
	
	private String backdrop_path;
	
	private long vote_average;
	
	private int vote_count;
	
	@ElementCollection
	private List <SeasonInfo> seasons;
	
	
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


	public int getNumber_of_episodes() {
		return number_of_episodes;
	}


	public void setNumber_of_episodes(int number_of_episodes) {
		this.number_of_episodes = number_of_episodes;
	}


	public int getNumber_of_seasons() {
		return number_of_seasons;
	}


	public void setNumber_of_seasons(int number_of_seasons) {
		this.number_of_seasons = number_of_seasons;
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

	

	public String getBackdrop_path() {
		return backdrop_path;
	}


	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}


	public long getVote_average() {
		return vote_average;
	}


	public void setVote_average(long vote_average) {
		this.vote_average = vote_average;
	}


	public int getVote_count() {
		return vote_count;
	}


	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public List<SeasonInfo> getSeasons() {
		return seasons;
	}


	public void setSeasonInfo(List<SeasonInfo> seasons) {
		this.seasons = seasons;
	}



	private static final long serialVersionUID = 1L;

}
