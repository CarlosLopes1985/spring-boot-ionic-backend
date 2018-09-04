package com.cursoudemy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.spring.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	
	
	
}
