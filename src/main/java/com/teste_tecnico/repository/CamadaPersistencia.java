package com.teste_tecnico.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.teste_tecnico.model.Cargo;
//import com.teste_tecnico.model.Pessoa;

public class CamadaPersistencia {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositórios
		CargoRepository cargoRepository = new CargoRepository(em);
//		PessoaRepository pessoaRepository = new PessoaRepository(em);
		
		//Criando cargos
		Cargo cargo = new Cargo();		
		cargo.setNome("ESTAGIARIO");
		Cargo cargo2 = new Cargo();		
		cargo2.setNome("TECNICO");
		Cargo cargo3 = new Cargo();		
		cargo3.setNome("ANALISTA");
		Cargo cargo4 = new Cargo();		
		cargo4.setNome("COORDENADOR");
		Cargo cargo5 = new Cargo();		
		cargo5.setNome("GERENTE");

		//Criando Pessoa
//		Pessoa pessoa = new Pessoa();
//		pessoa.setNome("Murilo Azevedo");
//		pessoa.setCidade("Rio de Janeiro");
//		pessoa.setEmail("MuriloDiasAzevedo@armyspy.com");
//		pessoa.setCep("25755-351");
//		pessoa.setEndereco("Vila de Secretario 18");
//		pessoa.setPais("Brazil");
//		pessoa.setUsuario("Cousine");
//		pessoa.setTelefone("(24) 7129-8842");
//		pessoa.setDataNascimento("12/29/1945");
//		pessoa.setCargo(cargo2);
		
		//Salvando Cargos
		cargoRepository.salvar(cargo);
		cargoRepository.salvar(cargo2);
		cargoRepository.salvar(cargo3);
		cargoRepository.salvar(cargo4);
		cargoRepository.salvar(cargo5);
		
		//Salvando Pessoas
//		pessoaRepository.salvar(pessoa);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Cargo> listaDeCargos = cargoRepository.pesquisar("");
		System.out.println(listaDeCargos);
//		List<Pessoa> listaDePessoas = pessoaRepository.pesquisar("");
//		System.out.println(listaDePessoas);
		
		em.close();
		emf.close();
	}
}
