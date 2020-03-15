package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for ResultMovie
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="result_movies")
public class ResultMovie implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Integer popularity;
	
	private Integer vote_count;
	
	private boolean video;
	
	private String poster_path;
	
	private Integer id;
	
	private boolean adult;
	
	private String backdrop_path;
	
	private String original_languaje;
	
	private String original_title;
	
	private String title;
	
	private Integer vote_average;
	
	private String overview;
	
	private Date release_date;
	
	
	public Integer getPopularity() {
		return popularity;
	}


	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}


	public Integer getVote_count() {
		return vote_count;
	}


	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}


	public boolean isVideo() {
		return video;
	}


	public void setVideo(boolean video) {
		this.video = video;
	}


	public String getPoster_path() {
		return poster_path;
	}


	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


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


	public String getOriginal_languaje() {
		return original_languaje;
	}


	public void setOriginal_languaje(String original_languaje) {
		this.original_languaje = original_languaje;
	}


	public String getOriginal_title() {
		return original_title;
	}


	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getVote_average() {
		return vote_average;
	}


	public void setVote_average(Integer vote_average) {
		this.vote_average = vote_average;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public Date getRelease_date() {
		return release_date;
	}


	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}


	private static final long serialVersionUID = 1L;

}
