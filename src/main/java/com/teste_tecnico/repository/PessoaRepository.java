package com.teste_tecnico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.teste_tecnico.model.Pessoa;

public class PessoaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public PessoaRepository() {

	}

	public PessoaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}

	public List<Pessoa> pesquisar(String termo) {
		String jpql = "from Pessoa where nome like :termo";

		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);

		query.setParameter("termo", termo + "%");

		return query.getResultList();
	}
	
	public List<Pessoa> listarTudo() {
		String jpql = "from Pessoa";

		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);

		return query.getResultList();
	}

	public Pessoa salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}

	public void remover(Pessoa pessoa) {
		pessoa = porId(pessoa.getId());
		manager.remove(pessoa);
	}
}
