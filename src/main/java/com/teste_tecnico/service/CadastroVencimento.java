package com.teste_tecnico.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.teste_tecnico.model.Vencimento;
import com.teste_tecnico.repository.VencimentoRepository;
import com.teste_tecnico.util.Transacional;

public class CadastroVencimento implements Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private VencimentoRepository vencimentoRepository;
	
	@Transacional
	public void salvar(Vencimento vencimento) {
		vencimentoRepository.salvar(vencimento);
	}
	
	@Transacional
	public void excluir(Vencimento vencimento) {
		vencimentoRepository.remover(vencimento);
	}
}
