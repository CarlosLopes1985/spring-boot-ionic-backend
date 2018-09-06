package com.cursoudemy.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cursoudemy.spring.dto.ClienteDTO;
import com.cursoudemy.spring.entity.Cliente;
import com.cursoudemy.spring.repositories.ClienteRepository;
import com.cursoudemy.spring.resource.exception.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repoCliente;
	
	public Cliente find(Integer id) throws ObjectNotFoundException {
		
		Optional<Cliente>obj = repoCliente.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +",Tipo: "+ Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		return repoCliente.save(obj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		
		find(id);
		try {
			repoCliente.deleteById(id);
		} catch (DataIntegrityViolationException e ) {
			throw new DataIntegrityException("Não é possível excluir porque teêm entidades associadas");
		}
	}

	public List<Cliente> findAll() {
		
		return repoCliente.findAll();
	}

	public Page<Cliente>findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf( direction), orderBy);
		
		return repoCliente.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	public Cliente update(Cliente obj) throws ObjectNotFoundException {
		
		Cliente newObj = find(obj.getIdCliente());
		updateData(newObj,obj);
		
		return repoCliente.save(newObj);
	}
}
	

