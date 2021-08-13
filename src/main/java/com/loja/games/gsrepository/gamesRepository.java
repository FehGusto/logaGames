package com.loja.games.gsrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.games.model.games;

@Repository
public interface gamesRepository extends JpaRepository<games , Long> {
	public List<games> findAllByTituloContainingIgnoreCase (String titulo);

}
