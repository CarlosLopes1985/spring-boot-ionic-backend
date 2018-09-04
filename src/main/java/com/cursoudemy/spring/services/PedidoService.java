package com.cursoudemy.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.spring.entity.Pedido;
import com.cursoudemy.spring.repositories.PedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repoPedido;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		
		Optional<Pedido>obj = repoPedido.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +",Tipo: "+ Pedido.class.getName()));
	}

	
}
