package com.presentes.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.presentes.exceptions.PresenteComQtdNegativoExceptions;
import com.presentes.exceptions.PresentesExceptionsNotFound;
import com.presentes.model.Presente;
import com.presentes.services.PresenteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Presentes")
@RestController
@RequestMapping("/api/v1/presentes")
public class PresenteController {


	@Autowired
	PresenteService presenteService;

	@ApiOperation(value = "Retorna lista de todos Presentes")
	@GetMapping("/")
	public ResponseEntity<List<Presente>> findAll() {	
		return ResponseEntity.status(HttpStatus.OK).body(presenteService.findAllPresente());
	}

	@ApiOperation(value = "Retorna lista de Presentes por Categoria")
	@GetMapping("/categoria/{id}")
	public ResponseEntity<List<Presente>> findByCategoria(@PathVariable("id") long id) {
		return null;

	}

	@ApiOperation(value = "Retorna Presente passando um id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Presente> buscarporId(@PathVariable("id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(presenteService.findPresenteById(id));
	}

	@ApiOperation(value = "Remover um Presente passando um id")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		return null;
	}

	@ApiOperation(value = "Cadastra um Presente")
	@PostMapping(value = "/")
	public @ResponseBody ResponseEntity<?> cadastrar(@Valid @RequestBody Presente presente) throws PresentesExceptionsNotFound, PresenteComQtdNegativoExceptions {
		return ResponseEntity.status(HttpStatus.CREATED).body(presenteService.createPresente(presente));
	}

	@ApiOperation(value = "Atualizar um Presente")
	@PutMapping(value = "/")
	public @ResponseBody ResponseEntity<?> atualizar(@RequestBody Presente presente) {
		return ResponseEntity.status(HttpStatus.OK).body(presenteService.updatePresente(presente));

	}
}
