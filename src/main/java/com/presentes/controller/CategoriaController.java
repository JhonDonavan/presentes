package com.presentes.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.presentes.model.Categoria;
import com.presentes.services.CategoriaService;
import com.presentes.services.CategoriaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Categorias")
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@ApiOperation(value = "Retorna lista de todas Categorias")
	@GetMapping("/")
	public ResponseEntity<List<Categoria>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAllCategoria());
	}

	@ApiOperation(value = "Retorna Categoria por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Categoria>> show(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findCategoriaById(id));
	}

	@ApiOperation(value = "Remove Categoria por id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") int id) {
		categoriaService.deleteCategoria(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@ApiOperation(value = "Cadastra uma Categoria")
	@PostMapping(value = "/")
	public @ResponseBody ResponseEntity<?> cadastrar(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.createCategoria(categoria));
	}

	@ApiOperation(value = "Atualizar uma Categoria")
	@PutMapping(value = "/")
	public @ResponseBody ResponseEntity<?> atualizar(@Valid @RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.OK).body(categoriaService.updateCategoria(categoria));
	}

}
