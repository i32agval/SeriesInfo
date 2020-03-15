package com.seriesinfo.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Model for Rol
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name = "authorities", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "authority"})})
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbd;

	private String authority;

	public int getIdbd() {
		return idbd;
	}

	public void setIdbd(int idbd) {
		this.idbd = idbd;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	private static final long serialVersionUID = 1L;

}
