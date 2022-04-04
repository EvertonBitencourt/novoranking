package com.gamegol.ranking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Competicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Você não informou o nome da competição")
	@NotNull(message = "Você não informou o nome da competição")
	private String nome;
	
	
	@NotNull(message = "Você não informou os pontos do primeiro colocado")
	private int ponto_primeiro;
	
	
	@NotNull(message = "Você não informou os pontos do segundo colocado")
	private int ponto_segundo;
	
	
	@NotNull(message = "Você não informou os pontos do terceiro colocado")
	private int ponto_terceiro;
	
	
	@NotNull(message = "Você não informou os pontos do quarto colocado")
	private int ponto_quarto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPonto_primeiro() {
		return ponto_primeiro;
	}

	public void setPonto_primeiro(int ponto_primeiro) {
		this.ponto_primeiro = ponto_primeiro;
	}

	public int getPonto_segundo() {
		return ponto_segundo;
	}

	public void setPonto_segundo(int ponto_segundo) {
		this.ponto_segundo = ponto_segundo;
	}

	public int getPonto_terceiro() {
		return ponto_terceiro;
	}

	public void setPonto_terceiro(int ponto_terceito) {
		this.ponto_terceiro = ponto_terceito;
	}

	public int getPonto_quarto() {
		return ponto_quarto;
	}

	public void setPonto_quarto(int ponto_quarto) {
		this.ponto_quarto = ponto_quarto;
	}
			
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ponto_primeiro;
		result = prime * result + ponto_quarto;
		result = prime * result + ponto_segundo;
		result = prime * result + ponto_terceiro;
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
		Competicao other = (Competicao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ponto_primeiro != other.ponto_primeiro)
			return false;
		if (ponto_quarto != other.ponto_quarto)
			return false;
		if (ponto_segundo != other.ponto_segundo)
			return false;
		if (ponto_terceiro != other.ponto_terceiro)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "competicao [id=" + id + ", nome=" + nome + ", ponto_primeiro=" + ponto_primeiro + ", ponto_segundo="
				+ ponto_segundo + ", ponto_terceito=" + ponto_terceiro + ", ponto_quarto=" + ponto_quarto + "]";
	}
	
}
