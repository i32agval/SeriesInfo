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
 * Model for Lista
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="listas")
public class Lista implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	@ElementCollection
	private List<ResultList> results;
	
	private Integer page;
	
	private Integer total_pages;
	
	private Integer total_results;
	
	private String backdrop_path;
	
	

	
	public String getBackdrop_path() {
		return backdrop_path;
	}



	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}



	public List<ResultList> getResults() {
		return results;
	}



	public void setResults(List<ResultList> results) {
		this.results = results;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public Integer getTotal_pages() {
		return total_pages;
	}



	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}



	public Integer getTotal_results() {
		return total_results;
	}



	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}



	private static final long serialVersionUID = 1L;

}
