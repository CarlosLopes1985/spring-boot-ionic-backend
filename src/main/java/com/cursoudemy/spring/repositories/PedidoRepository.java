package com.cursoudemy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.spring.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	
	
	
}
