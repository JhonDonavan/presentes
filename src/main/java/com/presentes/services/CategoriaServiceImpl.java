package com.presentes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presentes.model.Categoria;
import com.presentes.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	String testDefoalt;
	
	@Autowired
	CategoriaRepository categoriRepository;

	@Override
	public List<Categoria> findAllCategoria() {
		return categoriRepository.findAll();
	}

	@Override
	public Optional<Categoria> findCategoriaById(int id) {
		Optional<Categoria> categorias = categoriRepository.findById(id);
		return categorias;
	}

	@Override
	public Categoria findCategoriaByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria createCategoria(Categoria categoria) {
		return categoriRepository.save(categoria);
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		Optional<Categoria> c = categoriRepository.findById(categoria.getId());
		return this.categoriRepository.saveAndFlush(categoria);

	}

	@Override
	public void deleteCategoria(int id) {
		Optional<Categoria> categoria = categoriRepository.findById(id);
		categoriRepository.deleteById(id);

	}

}
