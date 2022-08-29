package com.stefanini.food.stefood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stefanini.food.stefood.modelo.LojaProduto;

public interface LojaProdutoTesteRepository extends CrudRepository<LojaProduto, Long>{

	@Query(value = "SELECT lp.id, p.nome, p.descricao FROM " + "LojaProduto lp join Produto p ON p.id = lp.produto WHERE lp.loja.id = :idLoja")
	List<LojaProduto> findByLojaId(@Param("idLoja") Long idLoja);
}
