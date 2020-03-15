package com.seriesinfo.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Authentication
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="authentications")
public class Authentication implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private boolean success;
	
	private String request_token;
	
	private String account_id;
	
	private String access_token;


	
	public boolean isSuccess() {
		return success;
	}


	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	

	public String getRequest_token() {
		return request_token;
	}


	
	public void setRequest_token(String request_token) {
		this.request_token = request_token;
	}

	

	public String getAccount_id() {
		return account_id;
	}

	

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	

	public String getAccess_token() {
		return access_token;
	}


	
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	
	
	private static final long serialVersionUID = 1L;
}
