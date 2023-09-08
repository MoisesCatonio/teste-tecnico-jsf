package com.teste_tecnico.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.teste_tecnico.model.PessoaSalario;

public class PessoaSalarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public PessoaSalarioRepository() {

	}

	public PessoaSalarioRepository(EntityManager manager) {
		this.manager = manager;
	}

	public PessoaSalario porId(Long id) {
		return manager.find(PessoaSalario.class, id);
	}

	public List<PessoaSalario> porPessoa(Long id) {
		String jpql = "from PessoaSalario ps where ps.pessoa_id.id = :id";

		TypedQuery<PessoaSalario> query = manager.createQuery(jpql, PessoaSalario.class);

		query.setParameter("id", id);

		return query.getResultList();
	}
	
	public List<PessoaSalario> listarTudo() {
		return manager.createQuery("from PessoaSalario", PessoaSalario.class).getResultList();
	}
	
	public void salvar(PessoaSalario pessoaSalario) {
		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();
		manager.merge(pessoaSalario);
		transacao.commit();
	}

	public void remover(PessoaSalario pessoaSalario) {
		pessoaSalario = porId(pessoaSalario.getId());
		manager.remove(pessoaSalario);
	}
}
