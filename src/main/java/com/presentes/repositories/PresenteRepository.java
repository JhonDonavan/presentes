package com.presentes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.presentes.model.Presente;

@Repository
public interface PresenteRepository extends JpaRepository<Presente, Long> {

}
