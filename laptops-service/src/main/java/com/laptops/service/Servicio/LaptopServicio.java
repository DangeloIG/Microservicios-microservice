package com.laptops.service.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptops.service.Repositorio.LaptopRepositorio;
import com.laptops.service.entidades.Laptop;


@Service
public class LaptopServicio {

	@Autowired
	private LaptopRepositorio laptopRepositorio;
	
	public List<Laptop> getAll(){
		return laptopRepositorio.findAll();
	}
	
	public Laptop getLaptopById(int id) {
		return laptopRepositorio.findById(id).orElse(null);
	}
	
	public Laptop save(Laptop laptop) {
		Laptop nuevaLaptop = laptopRepositorio.save(laptop);
		return nuevaLaptop;
	}
	
	public List<Laptop> byUsuarioId(int usuarioId){
		return laptopRepositorio.findByUsuarioId(usuarioId);
	}
}

