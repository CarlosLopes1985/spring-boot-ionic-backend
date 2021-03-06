package com.cursoudemy.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cursoudemy.spring.dto.CategoriaDTO;
import com.cursoudemy.spring.entity.Categoria;
import com.cursoudemy.spring.repositories.CategoriaRepository;
import com.cursoudemy.spring.resource.exception.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repoCategoria;
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		
		Optional<Categoria>obj = repoCategoria.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id +",Tipo: "+ Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repoCategoria.save(obj);
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
	public Categoria update(Categoria obj) throws ObjectNotFoundException {
		
		Categoria newObj = find(obj.getId());
		updateData(newObj,obj);
		
		return repoCategoria.save(newObj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		
		find(id);
		try {
			repoCategoria.deleteById(id);
		} catch (DataIntegrityViolationException e ) {
			throw new DataIntegrityException("Não é possível excluir categoria que possui produtos");
		}
		
	}

	public List<Categoria> findAll() {
		
		return repoCategoria.findAll();
	}

	public Page<Categoria>findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		
		@SuppressWarnings("deprecation")
		PageRequest pageRequest = new PageRequest(page, linesPerPage,Direction.valueOf( direction), orderBy);
		
		return repoCategoria.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {

		return new Categoria(objDto.getId(), objDto.getNome());
	}
}
