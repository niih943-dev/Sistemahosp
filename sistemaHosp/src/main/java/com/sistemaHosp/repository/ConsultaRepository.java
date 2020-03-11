package com.sistemaHosp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistemaHosp.models.Consulta;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, String> {
	Consulta findByIdConsulta (long idConsulta);
}