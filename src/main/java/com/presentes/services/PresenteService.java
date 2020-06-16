package com.presentes.services;

import java.util.List;
import java.util.Optional;

import com.presentes.exceptions.PresenteComQtdNegativoExceptions;
import com.presentes.exceptions.PresentesExceptionsNotFound;
import com.presentes.model.Presente;


public interface PresenteService {
	
	List<Presente> findAllPresente();
	
	List<Presente> findPresenteByCategoriaNome(String categoria);
	
	List<Presente> findPresenteByCategoriaId(Long id);
	
	Presente findPresenteById(long id);
	
	Presente findPresenteByName(String nome);
	
	Presente createPresente(Presente presente) throws PresentesExceptionsNotFound, PresenteComQtdNegativoExceptions;
	
	Presente updatePresente(Presente presente);
	
	void deletePresente(long id);
	
	

}
