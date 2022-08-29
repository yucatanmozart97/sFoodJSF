package com.stefanini.food.stefood.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.stefanini.food.stefood.modelo.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long>{

	Optional<Loja> findById(Long id);
	
	List<Loja> findByNome(String nomeLoja);

	List<Loja> findByCnpj(String cnpj);
	
}
