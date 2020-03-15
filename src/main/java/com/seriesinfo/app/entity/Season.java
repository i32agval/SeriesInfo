package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.seriesinfo.app.entity.Result;

/**
 * Model for Season
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="seasons")

public class Season implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ElementCollection
	private List<Result> results = null;

	private String backdrop_path;
	
	private String overview;
	
	private String poster_path;
	
	private Integer page;
	
	private Integer total_results;
	
	private Integer total_pages;
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	public List<Result> getResults() {
		return results;
	}



	public void setResults(List<Result> results) {
		this.results = results;
	}


	public String getBackdrop_path() {
		return backdrop_path;
	}



	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
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



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public Integer getTotal_results() {
		return total_results;
	}



	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}



	public Integer getTotal_pages() {
		return total_pages;
	}



	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}



	private static final long serialVersionUID = 1L;
}
