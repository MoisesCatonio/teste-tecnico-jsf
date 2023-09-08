package com.teste_tecnico.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.teste_tecnico.model.PessoaSalario;
import com.teste_tecnico.repository.PessoaSalarioRepository;
import com.teste_tecnico.util.Transacional;

public class CadastroPessoaSalario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaSalarioRepository pessoaSalarioRepository;
	
	@Transacional
	public void salvar(PessoaSalario pessoaSalario) {
		pessoaSalarioRepository.salvar(pessoaSalario);
	}
	
	@Transacional
	public void excluir(PessoaSalario pessoaSalario) {
		pessoaSalarioRepository.remover(pessoaSalario);
	}
}
