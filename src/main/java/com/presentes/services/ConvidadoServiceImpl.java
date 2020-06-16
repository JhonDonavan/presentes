package com.presentes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.presentes.model.Convidado;
import com.presentes.repositories.ConvidadoRepository;

@Service
public class ConvidadoServiceImpl  implements ConvidadoService{

	@Autowired
	ConvidadoRepository convidadoRepository;
	
	@Override
	public List<Convidado> findAllConvidado() {
		return convidadoRepository.findAll();
	}

	@Override
	public Optional<Convidado> findConvidadoById(long id) {
		return convidadoRepository.findById(id);
	}

	@Override
	public Convidado findConvidadoByName(String nome) {
		return null;
	}

	@Override
	public Convidado createConvidado(Convidado convidado) {
		return convidadoRepository.save(convidado);
	}

	@Override
	public Convidado updateConvidado(Convidado convidado) {
		Optional<Convidado> convidadoOK = convidadoRepository.findById(convidado.getId());
		return this.convidadoRepository.saveAndFlush(convidadoOK);

	}

	@Override
	public void deleteConvidado(long id) {
		Optional<Convidado> convidado = convidadoRepository.findById(id);
		convidadoRepository.deleteById(id);
	}

}
