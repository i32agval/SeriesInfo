package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Movie
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="movies")
public class Movie implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Integer page;
	
	private Integer total_results;
	
	private Integer total_pages;
	
	@ElementCollection
	private List<ResultMovie> results;
	
	
	
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



	public List<ResultMovie> getResults() {
		return results;
	}



	public void setResults(List<ResultMovie> results) {
		this.results = results;
	}



	private static final long serialVersionUID = 1L;

}
