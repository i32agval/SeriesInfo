package com.seriesinfo.app.entity;

import java.io.Serializable;

/**
 * Model for ResultList
 * @author Luis Aguilar
 * @version 10/03/2020
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result_lists")
public class ResultList implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private String description;
	
	private Integer favorite_count;
	
	private Integer id;
	
	private Integer item_count;
	
	private String iso_639_1;
	
	private String list_type;
	
	private String name;
	
	private String poster_path;
	
	private String backdrop_path;
	
	private Integer number_of_items;
	

	
	public Integer getNumber_of_items() {
		return number_of_items;
	}



	public void setNumber_of_items(Integer number_of_items) {
		this.number_of_items = number_of_items;
	}



	public String getBackdrop_path() {
		return backdrop_path;
	}



	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getFavorite_count() {
		return favorite_count;
	}



	public void setFavorite_count(Integer favorite_count) {
		this.favorite_count = favorite_count;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getItem_count() {
		return item_count;
	}



	public void setItem_count(Integer item_count) {
		this.item_count = item_count;
	}



	public String getIso_639_1() {
		return iso_639_1;
	}



	public void setIso_639_1(String iso_639_1) {
		this.iso_639_1 = iso_639_1;
	}



	public String getList_type() {
		return list_type;
	}



	public void setList_type(String list_type) {
		this.list_type = list_type;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPoster_path() {
		return poster_path;
	}



	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}



	private static final long serialVersionUID = 1L;

}
