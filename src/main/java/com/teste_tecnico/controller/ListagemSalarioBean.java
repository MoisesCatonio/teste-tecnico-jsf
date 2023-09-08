package com.teste_tecnico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.teste_tecnico.model.Cargo;
import com.teste_tecnico.model.CargoVencimento;
import com.teste_tecnico.model.Pessoa;
import com.teste_tecnico.model.PessoaSalario;
import com.teste_tecnico.model.Vencimento;
import com.teste_tecnico.repository.CargoVencimentoRepository;
import com.teste_tecnico.repository.PessoaRepository;
import com.teste_tecnico.repository.PessoaSalarioRepository;
import com.teste_tecnico.repository.VencimentoRepository;

@Named
@SessionScoped
public class ListagemSalarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaRepository pR;

	@Inject
	private PessoaSalarioRepository pSR;

	@Inject
	private CargoVencimentoRepository cVR;

	@Inject
	private VencimentoRepository vR;

	private List<PessoaSalario> listaSalario;

	@PostConstruct
	public void init() {
		listarSalario();
	}

	public ListagemSalarioBean() {

	}

	public ListagemSalarioBean(PessoaRepository pR, PessoaSalarioRepository pSR, CargoVencimentoRepository cVR,
			VencimentoRepository vR) {
		this.pR = pR;
		this.pSR = pSR;
		this.cVR = cVR;
		this.vR = vR;
	}

	public void calcularSalarios() {

		List<Pessoa> pessoas = pR.listarTudo();

		for (Pessoa pessoa : pessoas) {

			PessoaSalario pS = new PessoaSalario();

			List<PessoaSalario> listaVerificaExistencia = pSR.porPessoa(pessoa.getId());

			if (listaVerificaExistencia.size() > 0) {
				pS.setId(listaVerificaExistencia.get(0).getId());
			}

			pS.setPessoa(pessoa.getNome());
			pS.setPessoa_id(pessoa);

			long salario = 0;

			Cargo cargo = pessoa.getCargo();
			pS.setCargo(cargo.getNome());

			List<CargoVencimento> vencimentosParaCargo = cVR.porCargoId(cargo.getId());

			for (CargoVencimento cargoVencimento : vencimentosParaCargo) {
				List<Vencimento> vencimentos = new ArrayList<Vencimento>();
				vencimentos.add(vR.porId(cargoVencimento.getVencimento().getId()));
				for (Vencimento vencimento : vencimentos) {
					if (vencimento.getTipo().toUpperCase().contains("CREDITO")) {
						salario = salario + vencimento.getValor();
					} else {
						salario = salario - vencimento.getValor();
					}
				}
			}
			pS.setSalario(salario);
			System.out.println(listaSalario);
			pSR.salvar(pS);

		}
	}

	public void listarSalario() {
		listaSalario = pSR.listarTudo();
	}

	public List<PessoaSalario> getListaSalario() {
		return listaSalario;
	}

}
