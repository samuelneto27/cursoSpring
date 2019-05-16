package com.samuel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.cursomc.domain.Categoria;
import com.samuel.cursomc.repository.CategoriaRepository;
import com.samuel.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository cr;
	
	public Categoria buscar(Integer id) {
		Optional <Categoria> obj = cr.findById(id);
		
		if ( obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id + ", Tipo: "+ Categoria.class.getName());
		}
		
		return obj.orElse(null);
	}

}
