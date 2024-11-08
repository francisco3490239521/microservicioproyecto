package com.usuario.servicefm.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuario.servicefm.entidades.usuario;

@Repository
public interface UsuarioRespositorio<Interger> extends JpaRepository<usuario, Interger>{

	Optional<usuario> findById(int id);

	<Usuario, S> Usuario saveAll(S usuario);

}
