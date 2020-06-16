package com.presentes.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.presentes.model.Convidado;
import com.presentes.services.ConvidadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value = "Convidados")
@RestController
@RequestMapping("/api/v1/convidados")
public class ConvidadoController {

	@Autowired
	ConvidadoService convidadoService;

	@ApiOperation(value = "Retorna lista de todas os convidados")
	@GetMapping("/")
	public ResponseEntity<List<Convidado>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(convidadoService.findAllConvidado());
	}

	@ApiOperation(value = "Retorna convidado por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Convidado>> show(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(convidadoService.findConvidadoById(id));
	}

	@ApiOperation(value = "Remove convidado por id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") int id) {
		convidadoService.deleteConvidado(id);
		;
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@ApiOperation(value = "Cadastra um convidado")
	@PostMapping(value = "/")
	public @ResponseBody ResponseEntity<?> cadastrar(@Valid @RequestBody Convidado convidado) {
		return ResponseEntity.status(HttpStatus.CREATED).body(convidadoService.createConvidado(convidado));
	}

	@ApiOperation(value = "Atualizar um convidado")
	@PutMapping(value = "/")
	public @ResponseBody ResponseEntity<?> atualizar(@Valid @RequestBody Convidado convidado) {
		return ResponseEntity.status(HttpStatus.OK).body(convidadoService.updateConvidado(convidado));
	}

}
