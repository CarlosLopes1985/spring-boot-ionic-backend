package com.cursoudemy.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.spring.entity.Cliente;
import com.cursoudemy.spring.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repoCliente;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		
		Optional<Cliente>obj = repoCliente.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +",Tipo: "+ Cliente.class.getName()));
	}

	
}
