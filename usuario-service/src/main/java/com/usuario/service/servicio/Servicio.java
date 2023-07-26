package com.usuario.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.repository.Repositorio;

@Service

public class Servicio {
	
	@Autowired
	private Repositorio Repositorio;
	
	public List<Usuario> getAll(){
		return Repositorio.findAll();
	}
	
	public Usuario getUsuarioById(int id) {
		return Repositorio.findById(id).orElse(null);
	}
	
	public Usuario save (Usuario usuario) {
		Usuario nuevoUsuario = Repositorio.save(usuario);
		return nuevoUsuario;
	}
}
