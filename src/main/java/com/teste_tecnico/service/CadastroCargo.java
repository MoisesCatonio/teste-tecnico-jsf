package com.teste_tecnico.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.teste_tecnico.model.Cargo;
import com.teste_tecnico.repository.CargoRepository;
import com.teste_tecnico.util.Transacional;

public class CadastroCargo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CargoRepository cargoRepository;
	
	@Transacional
	public void salvar(Cargo cargo) {
		cargoRepository.salvar(cargo);
	}
	
	@Transacional
	public void excluir(Cargo cargo) {
		cargoRepository.remover(cargo);
	}
}
