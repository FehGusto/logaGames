package com.loja.games.gsrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.games.model.Usuario;


public interface usuarioRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByEmail (String email);

}
