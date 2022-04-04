package com.gamegol.ranking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ResultadoCompeticao {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank(message = "Você não informou a edição da competição")
	@NotNull(message = "Você não informou a edição da competição")
	private String edicao;
	
	@JoinColumn(name = "id")
	private Time primeiroColocado;
	@JoinColumn(name = "id")
	private Time segundoColocado;
	@JoinColumn(name = "id")
	private Time terceiroColocado;
	@JoinColumn(name = "id")
	private Time quartoColocado;
	
	
	@JoinColumn(name = "id")
	private Competicao competicao;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Time getPrimeiroColocado() {
		return primeiroColocado;
	}

	public void setPrimeiroColocado(Time primeiroColocado) {
		this.primeiroColocado = primeiroColocado;
	}

	public Time getSegundoColocado() {
		return segundoColocado;
	}

	public void setSegundoColocado(Time segundoColocado) {
		this.segundoColocado = segundoColocado;
	}

	public Time getTerceiroColocado() {
		return terceiroColocado;
	}

	public void setTerceiroColocado(Time terceiroColocado) {
		this.terceiroColocado = terceiroColocado;
	}

	public Time getQuartoColocado() {
		return quartoColocado;
	}

	public void setQuartoColocado(Time quartoColocado) {
		this.quartoColocado = quartoColocado;
	}

	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoCompeticao other = (ResultadoCompeticao) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
