package com.televisor.service.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.televisor.service.Servicio.TelevisorServicio;
import com.televisor.service.entiades.Televisor;

@RestController
@RequestMapping("/televisor")
public class TelevisorControlador {

	@Autowired
	private TelevisorServicio televisorServicio;
	
	@GetMapping
	public ResponseEntity<List<Televisor>> listarTelevisores(){
		List <Televisor> televisores = televisorServicio.getAll();
		if(televisores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(televisores);
	}
	@GetMapping("/id")
	public ResponseEntity<Televisor> obtenerTelevisor(@PathVariable("id")int id){
		Televisor televisor = televisorServicio.getTelevisorById(id);
		if(televisor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(televisor);
	}
	
	@PostMapping
	public ResponseEntity<Televisor> guardarTelevisor(@RequestBody Televisor televisor){
		Televisor nuevoTelevisor = televisorServicio.save(televisor);
		return ResponseEntity.ok(nuevoTelevisor);
	}
	@GetMapping("/usuario/{usuariosId}")
	public ResponseEntity<List<Televisor>> listarTelevisorPorUsuarioId(@PathVariable("usuarioId")int id){
		List<Televisor> televisores = televisorServicio.byUsuarioId(id);
		if(televisores.isEmpty()) {
			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.ok(televisores);
	}
	
}
