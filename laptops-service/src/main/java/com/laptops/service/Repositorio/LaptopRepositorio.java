package com.laptops.service.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptops.service.entidades.Laptop;

@Repository
public interface LaptopRepositorio extends JpaRepository<Laptop, Integer>{
	List<Laptop> findByUsuarioId(int usuarioId);
	


}
