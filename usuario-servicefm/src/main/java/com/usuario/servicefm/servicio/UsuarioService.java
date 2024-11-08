package com.usuario.servicefm.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.servicefm.entidades.usuario;
import com.usuario.servicefm.repositorio.UsuarioRespositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRespositorio<?> usuarioRepositorio;
    
	public List<usuario> getAll(){
		return usuarioRepositorio . findAll();
	}
	
	public usuario getUsuarioById(int id) {
		return usuarioRepositorio.findById(id).orElse(null);

	}
	
	public <Usuario, S> Usuario save(Usuario usuario) {
		@SuppressWarnings("unchecked")
		Usuario nuevoUsuario = usuarioRepositorio.saveAll((S) usuario);
		return nuevoUsuario;
	}
}
