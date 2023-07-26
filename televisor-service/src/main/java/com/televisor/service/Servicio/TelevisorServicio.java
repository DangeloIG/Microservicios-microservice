package com.televisor.service.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.televisor.service.Repositorio.TelevisorRepositorio;
import com.televisor.service.entiades.Televisor;

@Service
public class TelevisorServicio {

	@Autowired
	private TelevisorRepositorio televisorRepositorio;
	
	public List<Televisor> getAll(){
		return televisorRepositorio.findAll();
	}
	
	public Televisor getTelevisorById(int id) {
		return televisorRepositorio.findById(id).orElse(null);
	}
	
	public Televisor save (Televisor televisor) {
		Televisor nuevoTelevisor = televisorRepositorio.save(televisor);
		return nuevoTelevisor;
	}
	
	public List<Televisor> byUsuarioId(int usuarioId){
		return televisorRepositorio.findByUsuarioId(usuarioId);
	}
}
