package br.com.api.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.bookstore.models.Categoria;
import br.com.api.bookstore.models.Livro;
import br.com.api.bookstore.repositories.CategoriaRepository;
import br.com.api.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public void instanciaBaseDeDados() {
		
	Categoria cat1 = new Categoria(null, "Informatica","Livros de TI");
	Categoria cat2 = new Categoria(null, "Mecanica","Livros de Mecanica");
	Categoria cat3 = new Categoria(null, "Desenho","Livros de Desenho");
	Categoria cat4 = new Categoria(null, "Administração","Livros de Admin");
	Categoria cat5 = new Categoria(null, "Redes de Conputadores","Livros de Redes");
	
	Livro l1 = new Livro(null, "Java Man","Everton","Aprendendo Java", cat1);
	Livro l2 = new Livro(null, "JMec Draw","Everton","Aprendendo Mecanca", cat2);
	Livro l3 = new Livro(null, "Java Man","Everton","Aprendendo Java", cat3);
	Livro l4 = new Livro(null, "Java Man","Everton","Aprendendo Java", cat4);
	Livro l5 = new Livro(null, "Java Man","Everton","Aprendendo Java", cat5);
	Livro l6 = new Livro(null, "Java Man","Everton","Aprendendo Java", cat3);
	Livro l7 = new Livro(null, "Java Man","Everton","Aprendendo Java", cat3);
	Livro l8 = new Livro(null, "Java Man","Everton","Aprendendo Java", cat3);
	
	cat1.getLivros().addAll(Arrays.asList(l1));
	cat2.getLivros().addAll(Arrays.asList(l2));
	cat3.getLivros().addAll(Arrays.asList(l3,l6,l7,l8));
	cat4.getLivros().addAll(Arrays.asList(l4));
	cat5.getLivros().addAll(Arrays.asList(l5));
	
	this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
	this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8));
	
	}
}
