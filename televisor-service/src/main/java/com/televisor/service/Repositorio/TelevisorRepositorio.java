package com.televisor.service.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.televisor.service.entiades.Televisor;

@Repository
public interface TelevisorRepositorio extends JpaRepository<Televisor, Integer>{
	List <Televisor> findByUsuarioId(int usuarioId);
}


