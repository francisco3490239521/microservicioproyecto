package com.usuario.servicefm.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.servicefm.entidades.usuario;
import com.usuario.servicefm.servicio.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<usuario>> listarUsuario(){
		List<usuario> usuarios = usuarioService.getAll();
		if(usuarios.isEmpty()) 
	return ResponseEntity.noContent().build();
	
	return ResponseEntity.ok(usuarios);
	}
 
	@GetMapping("/{id}")
	public ResponseEntity<usuario> Obtenerusuario(@PathVariable("id") int id) {
		usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<usuario> guardarUsuario(@RequestBody usuario usuario) {
		usuario nuevousuario = usuarioService.save(usuario);
		return ResponseEntity.ok(nuevousuario);
	}
}
