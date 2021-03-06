package br.com.api.bookstore.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	private String nome;
	private String texto;
	
	@JsonIgnore //para nao trazer a categoria dos livros. Se nao colocar da erro infinito na busca,,repetindo a categora de cada livro..loop infinito
	//Esta ação é a proteção contra serialização - nem funciona no swaggger se nao colocar
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;

	public Livro() {
		
	}

	public Livro(Integer id, String titulo, String nome, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nome = nome;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
