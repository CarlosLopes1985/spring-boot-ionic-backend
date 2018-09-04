package com.cursoudemy.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.spring.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	
	
	
}
