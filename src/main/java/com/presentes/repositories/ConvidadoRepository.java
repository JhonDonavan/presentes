package com.presentes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.presentes.model.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

	Convidado saveAndFlush(Optional<Convidado> convidado);

}
