package com.presentes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presentes.exceptions.PresenteComQtdNegativoExceptions;
import com.presentes.exceptions.PresentesExceptionsNotFound;
import com.presentes.model.Presente;
import com.presentes.repositories.PresenteRepository;

@Service
public class PresenteServiceImpl implements PresenteService {
	
	@Autowired
	PresenteRepository presenteRepository;
	
	
	@Override
	public List<Presente> findAllPresente() {
		List<Presente> presentes = presenteRepository.findAll();
		return presentes;
	}

	@Override
	public List<Presente> findPresenteByCategoriaNome(String categoria) {
		// TODO CRIAR BUNSCA DE PRESENTES PELO NOME DA CATEGORIA
		return null;
	}

	@Override
	public List<Presente> findPresenteByCategoriaId(Long id) {
		// TODO CRIAR BUNSCA DE PRESENTES PELO ID DA CATEGORIA
		return null;
	}

	@Override
	public Presente findPresenteById(long id) {
		Presente foundPresente = foundPresente(id);
		return foundPresente;
	}

	@Override
	public Presente findPresenteByName(String nome) {
		// TODO CRIAR BUNSCA DE PRESENTES PELO NOME DO PRESENTE
		return null;
	}

	@Override
	public Presente createPresente(Presente presente)  {
		
		if(presente.getCategoria() == null) {
			//TODO criar execeção para categoria inválida
			//throw new PresentesExceptionsNotFound();
		}
		
		if(presente.getConvidado() == null) {
			//TODO criar execeção para convidado inválida
			//throw new PresentesExceptionsNotFound();
		}
		
		if(presente.getQtd() < 0) {
			
		}
		    
		presenteRepository.save(presente);
		
		return presente;
	}

	@Override
	public Presente updatePresente(Presente presente) {
		Presente foundPresente = foundPresente(presente.getId());
		return foundPresente;
	}

	@Override
	public void deletePresente(long id) {
		Presente foundPresente = foundPresente(id);
		presenteRepository.delete(foundPresente);
		
	}
	
	public Presente foundPresente(long id) {
		return presenteRepository.findById(id).orElseThrow(()-> new PresentesExceptionsNotFound(id));
	}

}
