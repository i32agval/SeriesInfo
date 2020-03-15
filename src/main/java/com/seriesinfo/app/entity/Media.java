package com.seriesinfo.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Media
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="media")
public class Media implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private int id;
	
	private String name;
	
	private String title;
	
	private String media_type;
	
	private String poster_path;

	
	
	public int getId() {
		return id;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getTitle() {
		return title;
	}

	
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public String getMedia_type() {
		return media_type;
	}

	
	
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	
	
	public String getPoster_path() {
		return poster_path;
	}

	
	
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	
	
	
	private static final long serialVersionUID = 1L;
}
