package com.usuario.service.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.servicio.Servicio;

@RestController
@RequestMapping("/usuario")
public class Controlador {
	@Autowired
	private Servicio Servicio;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List <Usuario> usuarios = Servicio.getAll();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.ok(usuarios);
	}
	@GetMapping("/id")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id")int id){
		Usuario usuario = Servicio.getUsuarioById(id);
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		Usuario nuevoUsuario = Servicio.save(usuario);
		return ResponseEntity.ok(nuevoUsuario);
}
}

