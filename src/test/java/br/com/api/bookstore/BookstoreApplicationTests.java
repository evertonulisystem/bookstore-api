package br.com.api.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.api.bookstore.controllers.CategoriaController;
import br.com.api.bookstore.models.Categoria;
import br.com.api.bookstore.services.CategoriaService;

@SpringBootTest
class BookstoreApplicationTests{

	@Autowired
	private CategoriaController categoriaController;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@Test
	void contextLoads() {
	}

	
	@Test
	public void testCadastroCategoria() {
		Categoria categoria = new Categoria();
		categoria.setNome("Livro Teste");
		categoria = categoriaController.create(categoria).getBody();
		
		assertEquals(true, categoria.getId() >0);
	}
	
}
