package com.example.crm.model;

import java.util.Objects;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	private String denatran;
	private String ativo;
	
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	private List<Modelo> modelo;

	public List<Modelo> getModelos() {
		return modelo;
	}

	public void setModelos(List<Modelo> modelo) {
		this.modelo = modelo;
	}

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

	public String getDenatran() {
		return denatran;
	}

	public void setDenatran(String denatran) {
		this.denatran = denatran;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
