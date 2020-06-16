package com.presentes.services;

import java.util.List;
import java.util.Optional;

import com.presentes.model.Convidado;

public interface ConvidadoService {
	
	List<Convidado> findAllConvidado();
		
	Optional<Convidado> findConvidadoById(long id);
	
	Convidado findConvidadoByName(String nome);
	
	Convidado createConvidado(Convidado convidado);
	
	Convidado updateConvidado(Convidado convidado);
	
	void deleteConvidado(long id);

}
