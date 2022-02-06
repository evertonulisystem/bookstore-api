package br.com.api.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.bookstore.exception.ObjectNotFoundException;
import br.com.api.bookstore.models.Categoria;
import br.com.api.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
			Optional<Categoria> obj =categoriaRepository.findById(id);
			
			// sem exceçaõ seria assim >> return obj.orElse(null);
			//mais limpo abaixo return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id + ",Tipo: " + Categoria.class.getName()));
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	
}