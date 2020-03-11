package com.sistemaHosp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consulta implements Serializable{
	

private static final long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	private long idConsulta;
	
	private String especialista;
	private String sintomas;
	private String dtConsulta;
	private String horario;
	
	public long getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(long idConsulta) {
		this.idConsulta = idConsulta;
	}
	public String getEspecialista() {
		return especialista;
	}
	public void setEspecialista(String especialista) {
		this.especialista = especialista;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getDtConsulta() {
		return dtConsulta;
	}
	public void setDtConsulta(String dtConsulta) {
		this.dtConsulta = dtConsulta;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
}