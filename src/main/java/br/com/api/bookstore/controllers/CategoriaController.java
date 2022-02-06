package br.com.api.bookstore.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.bookstore.DTO.CategoriaDTO;
import br.com.api.bookstore.models.Categoria;
import br.com.api.bookstore.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/api/categorias")
public class CategoriaController {
	
	@Autowired 
	private CategoriaService categoriaService;
	
	@Tag(name="Categoria")
    @Operation(summary = "Obter Categoria por ID")
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@Tag(name="Categoria")
    @Operation(summary = "Lista de Categorias")
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> list = categoriaService.findAll(); //abaixo transformando Categoria em CategoriaDTO sem mapper
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDTO);
	}
	
	@Tag(name="Categoria")
    @Operation(summary = "Cadastrar Categoria")
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj ) {
		obj = categoriaService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		//return ResponseEntity.created(uri).body(obj); //ficando build, não retorna nada no RESPONSE bODY
		return ResponseEntity.created(uri).build();
				
	}

	@Tag(name="Categoria")
    @Operation(summary = "Atualizar dados de Categoria")
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO objDto ) {
		Categoria newObj = categoriaService.update(id, objDto);
		return ResponseEntity.ok().body(new CategoriaDTO(newObj));
				
	}
	
	
}
