package com.teste_tecnico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.teste_tecnico.model.Vencimento;

public class VencimentoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public VencimentoRepository() {

	}

	public VencimentoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Vencimento porId(Long id) {
		return manager.find(Vencimento.class, id);
	}

	public List<Vencimento> pesquisar(String termo) {
		String jpql = "from Vencimento where descricao like :termo";

		TypedQuery<Vencimento> query = manager.createQuery(jpql, Vencimento.class);

		query.setParameter("termo", termo + "%");

		return query.getResultList();
	}

	public Vencimento salvar(Vencimento vencimento) {
		return manager.merge(vencimento);
	}

	public void remover(Vencimento vencimento) {
		vencimento = porId(vencimento.getId());
		manager.remove(vencimento);
	}

}
