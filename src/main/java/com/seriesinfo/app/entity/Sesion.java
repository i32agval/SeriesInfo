package com.seriesinfo.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Sesion
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="sesions")
public class Sesion implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer idbd;
	
	private boolean success;
	
	private String session_id;
	
	
	public boolean isSuccess() {
		return success;
	}



	public void setSuccess(boolean success) {
		this.success = success;
	}



	public String getSession_id() {
		return session_id;
	}



	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}



	private static final long serialVersionUID = 1L;

}
