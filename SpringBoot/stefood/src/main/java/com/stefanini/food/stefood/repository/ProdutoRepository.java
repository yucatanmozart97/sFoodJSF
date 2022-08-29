package com.stefanini.food.stefood.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.food.stefood.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Optional<Produto> findById(Long id);
		
//	@Query();
//	List<Produto> findAllById(@Param("lojaFK")Long id);
	
}
