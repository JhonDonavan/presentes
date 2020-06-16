package com.presentes.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class ItemPresente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Presente presente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Convidado convidado;
	
	private String msg;
	private LocalDate data;
	

	public Long getId() {
		return id;
	}

	public Presente getPresente() {
		return presente;
	}

	public void setPresente(Presente presente) {
		this.presente = presente;
	}

	public Convidado getConvidado() {
		return convidado;
	}

	public void setConvidado(Convidado convidado) {
		this.convidado = convidado;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public ItemPresente(Long id, Presente presente, Convidado convidado, String msg, LocalDate data) {
		this.id = id;
		this.presente = presente;
		this.convidado = convidado;
		this.msg = msg;
		this.data = data;
	}

	public ItemPresente() {

	}

}
