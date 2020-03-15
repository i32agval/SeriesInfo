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
 * Model for Credit
 * @author Luis Aguilar
 * @version 10/03/2020
 */

@Entity
@Table(name="credits")
public class Credit implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbd;
	
	private Integer id;
	
	@ElementCollection
	private List<Cast> cast;
	

	
	public Integer getId() {
		return id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	

	public List<Cast> getCast() {
		return cast;
	}


	
	public void setCast(List<Cast> cast) {
		this.cast = cast;
	}

	
	
	private static final long serialVersionUID = 1L;

}
