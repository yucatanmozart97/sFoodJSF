package com.stefanini.food.stefood.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stefanini.food.stefood.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByUserName (String userName);
	List<Usuario> findByEmail (String email);
	List<Usuario> findByTelefone (String telefone);
	
	@Query("SELECT u FROM Usuario u where u.userName = :userName")
	Optional<Usuario> achePorUsuario (String userName);
}
