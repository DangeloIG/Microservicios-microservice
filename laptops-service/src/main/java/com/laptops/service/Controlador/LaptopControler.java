package com.laptops.service.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptops.service.Servicio.LaptopServicio;
import com.laptops.service.entidades.Laptop;



@RestController
@RequestMapping("/laptop")
public class LaptopControler {

	@Autowired
	private LaptopServicio laptopServicio;
	
	@GetMapping
	public ResponseEntity<List<Laptop>> listarLaptop(){
		List <Laptop> laptops = laptopServicio.getAll();
		if(laptops.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(laptops);
	}
	@GetMapping("/id")
	public ResponseEntity<Laptop> obtenerLaptop(@PathVariable("id")int id){
		Laptop laptop = laptopServicio.getLaptopById(id);
		if(laptop == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(laptop);
	}
	
	@PostMapping
	public ResponseEntity<Laptop> guardarLaptop(@RequestBody Laptop laptop){
		Laptop nuevaLaptop = laptopServicio.save(laptop);
		return ResponseEntity.ok(nuevaLaptop);
	}
	@GetMapping("/usuario/{usuariosId}")
	public ResponseEntity<List<Laptop>> listarLaptopPorUsuarioId(@PathVariable("usuarioId")int id){
		List<Laptop> laptops = laptopServicio.byUsuarioId(id);
		if(laptops.isEmpty()) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.ok(laptops);
	}
	
}
