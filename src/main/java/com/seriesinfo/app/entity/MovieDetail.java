package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for MovieDetail
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="movies_detail")
public class MovieDetail implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private boolean adult;
	
	private String backdrop_path;
	
	private Integer budget;
	
	private String homepage;
	
	private Integer id;
	
	private String imdb_id;
	
	private String original_title;
	
	private String overview;
	
	private Integer popularity;
	
	private String poster_path;
	
	private Date release_date;
	
	private Integer runtime;
	
	private String title;
	
	private boolean video;
	
	private Integer vote_average;
	
	private Integer vote_count;
	
	
	public boolean isAdult() {
		return adult;
	}


	public void setAdult(boolean adult) {
		this.adult = adult;
	}


	public String getBackdrop_path() {
		return backdrop_path;
	}


	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}


	public Integer getBudget() {
		return budget;
	}


	public void setBudget(Integer budget) {
		this.budget = budget;
	}


	public String getHomepage() {
		return homepage;
	}


	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getImdb_id() {
		return imdb_id;
	}


	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}


	public String getOriginal_title() {
		return original_title;
	}


	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public Integer getPopularity() {
		return popularity;
	}


	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}


	public String getPoster_path() {
		return poster_path;
	}


	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}


	public Date getRelease_date() {
		return release_date;
	}


	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}


	public Integer getRuntime() {
		return runtime;
	}


	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isVideo() {
		return video;
	}


	public void setVideo(boolean video) {
		this.video = video;
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
