package com.sistemaHosp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sistemaHosp.models.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, String>{
	Paciente findByIdPaciente (long idPaciente);
}