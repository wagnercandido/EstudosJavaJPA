package com.educandoweb.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.couse.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}
