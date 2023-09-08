package com.teste_tecnico.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.teste_tecnico.model.Pessoa;
import com.teste_tecnico.repository.PessoaRepository;
import com.teste_tecnico.util.Transacional;

public class CadastroPessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaRepository pessoaRepository;
	
	@Transacional
	public void salvar(Pessoa pessoa) {
		pessoaRepository.salvar(pessoa);
	}
	
	@Transacional
	public void excluir(Pessoa pessoa) {
		pessoaRepository.remover(pessoa);
	}
}
