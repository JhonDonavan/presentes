package com.presentes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "presentes")
public class Presente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Convidado convidado;

	@NotBlank(message = "Favor, informar um nome")
	private String nome;

	private String cor;
	
	private int qtd;

	private String observacao;

	@Override
	public String toString() {
		return "Presentes [id=" + id + ", nome=" + nome + ", cor=" + cor + ", qtd=" + qtd + ", observacao=" + observacao
				+ ", categoria_id=" + categoria + "]";
	}

	public Convidado getConvidado() {
		return convidado;
	}

	public void setConvidado(Convidado convidado) {
		this.convidado = convidado;
	}

	public long getId() {
		return id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Presente(int id, Categoria categoria, Convidado convidado,
			@NotBlank(message = "Favor, informar um nome") String nome, String cor,
			@NotBlank(message = "Favor, informar a quantidade") int qtd, String observacao) {
		this.id = id;
		this.categoria = categoria;
		this.convidado = convidado;
		this.nome = nome;
		this.cor = cor;
		this.qtd = qtd;
		this.observacao = observacao;
	}

	public Presente() {
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Presente other = (Presente) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (qtd != other.qtd)
			return false;
		return true;
	}
}
