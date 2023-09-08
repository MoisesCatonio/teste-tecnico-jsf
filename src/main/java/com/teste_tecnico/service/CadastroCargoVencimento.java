package com.teste_tecnico.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.teste_tecnico.model.CargoVencimento;
import com.teste_tecnico.repository.CargoVencimentoRepository;
import com.teste_tecnico.util.Transacional;

public class CadastroCargoVencimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CargoVencimentoRepository cargoVencimentoRepository;
	
	@Transacional
	public void salvar(CargoVencimento cargoVencimento) {
		cargoVencimentoRepository.salvar(cargoVencimento);
	}
	
	@Transacional
	public void excluir(CargoVencimento cargoVencimento) {
		cargoVencimentoRepository.remover(cargoVencimento);
	}
}
