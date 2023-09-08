package com.teste_tecnico.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_salario")
public class PessoaSalario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length=512)
	private String pessoa;
	
	@Column(length=512)
	private String cargo;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa_id;

	@Column
	private Long salario;

	public Pessoa getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(Pessoa pessoa_id) {
		this.pessoa_id = pessoa_id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPessoa() {
		return pessoa;
	}

	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
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
		PessoaSalario other = (PessoaSalario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PessoaSalario [id=" + id + "]";
	}
	
}
