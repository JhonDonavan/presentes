package com.presentes.services;

import java.util.List;
import java.util.Optional;

import com.presentes.model.Categoria;

public interface CategoriaService {
	
	List<Categoria> findAllCategoria();
	
	Optional<Categoria> findCategoriaById(int id);
	
	Categoria findCategoriaByName(String nome);
	
	Categoria createCategoria(Categoria categoria);
	
	Categoria updateCategoria(Categoria categoria);
	
	void deleteCategoria(int id);
	
}
