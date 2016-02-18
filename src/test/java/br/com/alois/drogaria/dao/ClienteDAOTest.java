package br.com.alois.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Cliente;
import br.com.alois.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/09/2015"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		System.out.println("Cliente salvo com sucesso.");
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		for (Cliente cliente : resultado) {
			System.out.println("Rotal de registros encontrados: " + resultado.size());
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Data do Cadastro: " + cliente.getDataCadastro());
			System.out.println("Liberação: " + cliente.getLiberado());
			System.out.println("Nome Cliente: " + cliente.getPessoa().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Cliente não encontrado!");
		} else {
			System.out.println("Cliente encontrado:");
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("LIberação: " + cliente.getLiberado());
			System.out.println("Nome Cliente: " + cliente.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro excluido:");
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Data Cadastro: " + cliente.getDataCadastro());
			System.out.println("LIberação: " + cliente.getLiberado());
			System.out.println("Nome Cliente: " + cliente.getPessoa().getNome());
			clienteDAO.excluir(cliente);
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoCliente = 4L;
		Long codigoPessoa = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		cliente.setDataCadastro(new Date());
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		System.out.println("Registro antes da edição:");
		System.out.println("Código: " + cliente.getCodigo());
		System.out.println("Data Cadastro: " + cliente.getDataCadastro());
		System.out.println("LIberação: " + cliente.getLiberado());
		System.out.println("Nome Cliente: " + cliente.getPessoa().getNome());
		System.out.println();

		clienteDAO.editar(cliente);

		System.out.println("Registro depois da edição:");
		System.out.println("Código: " + cliente.getCodigo());
		System.out.println("Data Cadastro: " + cliente.getDataCadastro());
		System.out.println("LIberação: " + cliente.getLiberado());
		System.out.println("Nome Cliente: " + cliente.getPessoa().getNome());
	}
}