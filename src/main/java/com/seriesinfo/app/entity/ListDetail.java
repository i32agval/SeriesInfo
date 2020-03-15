package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seriesinfo.app.entity.Result;

/**
 * Model for ListDetail
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="list_details")
public class ListDetail implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Integer id;
	
	private String page;
	
	private Integer total_results;
	
	private Integer total_pages;
	
	private String name;
	
	private String description;
	
	private String backdrop_path;
	
	@ElementCollection
	private List<Result> results;
	
	private boolean publico;
	
	@JsonProperty("public")
	public boolean isPublico() {
		return publico;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public void setPublico(boolean publico) {
		this.publico = publico;
	}




	public String getPage() {
		return page;
	}




	public void setPage(String page) {
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




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getBackdrop_path() {
		return backdrop_path;
	}




	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}




	public List<Result> getResults() {
		return results;
	}




	public void setResults(List<Result> results) {
		this.results = results;
	}




	private static final long serialVersionUID = 1L;
	
	

}
