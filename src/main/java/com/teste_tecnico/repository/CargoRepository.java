package com.teste_tecnico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.teste_tecnico.model.Cargo;


public class CargoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public CargoRepository() {

	}

	public CargoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Cargo porId(Long id) {
		return manager.find(Cargo.class, id);
	}

	public List<Cargo> pesquisar(String termo) {
		String jpql = "from Cargo where nome like :termo";

		TypedQuery<Cargo> query = manager.createQuery(jpql, Cargo.class);

		query.setParameter("termo", termo + "%");

		return query.getResultList();
	}

	public Cargo salvar(Cargo cargo) {
		return manager.merge(cargo);
	}

	public void remover(Cargo cargo) {
		cargo = porId(cargo.getId());
		manager.remove(cargo);
	}
}
