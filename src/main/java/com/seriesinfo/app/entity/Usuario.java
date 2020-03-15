package com.seriesinfo.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Model for Usuario
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name = "users")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idbd;

	@Column(unique = true)
	private String username;

	private String password;

	private String api_key;

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	private String request_token;

	private String request_token_prov;

	private String request_token_valid;
	
	private String account_id;
	
	

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getRequest_token_prov() {
		return request_token_prov;
	}

	public void setRequest_token_prov(String request_token_prov) {
		this.request_token_prov = request_token_prov;
	}

	public String getRequest_token_valid() {
		return request_token_valid;
	}

	public void setRequest_token_valid(String request_token_valid) {
		this.request_token_valid = request_token_valid;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Rol> roles;

	public Integer getIdbd() {
		return idbd;
	}

	public void setIdbd(Integer idbd) {
		this.idbd = idbd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRequest_token() {
		return request_token;
	}

	public void setRequest_token(String request_token) {
		this.request_token = request_token;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;

}
