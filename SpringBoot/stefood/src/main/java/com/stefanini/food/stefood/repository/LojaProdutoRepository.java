package com.stefanini.food.stefood.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.food.stefood.controller.dto.DetalhesLojaProdutoDto;
import com.stefanini.food.stefood.modelo.LojaProduto;

public interface LojaProdutoRepository extends JpaRepository<LojaProduto, Long>{


	@Query(value = "SELECT l.nome, p.nome, p.descricao, lp.preco FROM " + "LojaProduto lp join Produto p ON p.id = lp.produto join Loja l on l.id = lp.loja WHERE lp.loja.id = :id")
	List<?> findByLojaId(Long id);


	
}
