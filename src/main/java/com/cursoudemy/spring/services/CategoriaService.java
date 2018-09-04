package com.cursoudemy.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.spring.entity.Categoria;
import com.cursoudemy.spring.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repoCategoria;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		
		Optional<Categoria>obj = repoCategoria.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +",Tipo: "+ Categoria.class.getName()));
	}

	
}
