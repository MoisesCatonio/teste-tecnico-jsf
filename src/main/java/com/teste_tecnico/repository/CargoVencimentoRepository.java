package com.teste_tecnico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.teste_tecnico.model.CargoVencimento;

public class CargoVencimentoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public CargoVencimentoRepository() {

	}

	public CargoVencimentoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public CargoVencimento porId(Long id) {
		return manager.find(CargoVencimento.class, id);
	}

	public List<CargoVencimento> porCargoId(Long id) {
		String jpql = "from CargoVencimento where cargo_id = :id";

		TypedQuery<CargoVencimento> query = manager.createQuery(jpql, CargoVencimento.class);

		query.setParameter("id", id);

		return query.getResultList();
	}

	public CargoVencimento salvar(CargoVencimento cargoVencimento) {
		return manager.merge(cargoVencimento);
	}

	public void remover(CargoVencimento cargoVencimento) {
		cargoVencimento = porId(cargoVencimento.getId());
		manager.remove(cargoVencimento);
	}
}
