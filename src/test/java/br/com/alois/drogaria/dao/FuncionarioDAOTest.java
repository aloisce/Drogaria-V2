package br.com.alois.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Funcionario;
import br.com.alois.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoPessoa = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		System.out.println("Pessoa encontrada:");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());

		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraTrabalho("CT56897123");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("11/09/2011"));
		funcionario.setPessoa(pessoa);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);

		System.out.println("Funcionário salvo com sucesso.");
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();

		System.out.println("Registros encontrados: " + resultado.size());

		for (Funcionario funcionario : resultado) {
			System.out.println("Carteira Trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Pessoa: " + funcionario.getPessoa().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 6L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Pessoa: " + funcionario.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro excluído:");
			System.out.println("Carteira Trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Pessoa: " + funcionario.getPessoa().getNome());

			funcionarioDAO.excluir(funcionario);

			System.out.println("Funcionário excluído com sucessos.");
		}
	}

	@Test
	public void editar() throws ParseException {
		Long codigoFuncionario = 3L;
		Long codigoPessoa = 1L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		if (funcionario == null || pessoa == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro antes da edição:");
			System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Pessoa: " + funcionario.getPessoa().getNome());

			funcionario.setCarteiraTrabalho("CT 4512245");
			funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2015"));
			funcionario.setPessoa(pessoa);

			funcionarioDAO.editar(funcionario);

			System.out.println("Registro editado:");
			System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Pessoa: " + funcionario.getPessoa().getNome());
		}
	}
}
