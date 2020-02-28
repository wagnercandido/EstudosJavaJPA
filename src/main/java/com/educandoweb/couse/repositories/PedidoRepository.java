package com.educandoweb.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.couse.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
