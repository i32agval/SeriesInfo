package com.seriesinfo.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.seriesinfo.app.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{

	public Usuario findByUsername(String username);
	
	@SuppressWarnings("unchecked")
	public Usuario save(Usuario usuario);
}
