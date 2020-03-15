package com.seriesinfo.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Cast
 * @author Luis Aguilar
 * @version 10/03/202010/02/2020.
 */

@Entity
@Table(name="casts")
public class Cast implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Integer cast_id;
	
	private String character;
	
	private String credit_id;
	
	private Integer id;
	
	private String name;
	
	private Integer order;
	
	private String profile_path;
	
	
	
	public Integer getCast_id() {
		return cast_id;
	}


	
	public void setCast_id(Integer cast_id) {
		this.cast_id = cast_id;
	}


	
	public String getCharacter() {
		return character;
	}


	
	public void setCharacter(String character) {
		this.character = character;
	}


	
	public String getCredit_id() {
		return credit_id;
	}


	
	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}


	
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

	

	public Integer getOrder() {
		return order;
	}

	

	public void setOrder(Integer order) {
		this.order = order;
	}


	
	public String getProfile_path() {
		return profile_path;
	}

	

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

	

	private static final long serialVersionUID = 1L;

}
