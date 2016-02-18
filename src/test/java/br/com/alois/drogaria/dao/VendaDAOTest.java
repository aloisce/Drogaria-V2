package br.com.alois.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Cliente;
import br.com.alois.drogaria.domain.Funcionario;
import br.com.alois.drogaria.domain.Venda;

public class VendaDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoCliente = 4L;
		Long codigoFuncionario = 3L;

		Venda venda = new Venda();

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);

		venda.setHorario(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("25/12/2014 17:45:15"));
		venda.setValorTotal(new BigDecimal("10.90"));
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);

		System.out.println("Registro salvo com sucesso.");
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Venda venda : resultado) {
			System.out.println("Horário da Venda: " + venda.getHorario());
			System.out.println("Valor Total: " + venda.getValorTotal());
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionário: " + venda.getFuncionario().getPessoa().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 8L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println("Horário da Venda: " + venda.getHorario());
			System.out.println("Valor Total: " + venda.getValorTotal());
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionário: " + venda.getFuncionario().getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 7L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro a ser excluído:");
			System.out.println("Horário: " + venda.getHorario());
			System.out.println("Valor Total: " + venda.getValorTotal());
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionário: " + venda.getFuncionario().getPessoa().getNome());

			vendaDAO.excluir(venda);

			System.out.println("Venda excluída com sucesso.");
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigoVenda = 2L;
		Long codigoCliente = 1L;
		Long codigoFuncionario = 2L;

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVenda);

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);

		if (venda == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro antes da edição:");
			System.out.println("Horário: " + venda.getHorario());
			System.out.println("Valor Total: " + venda.getValorTotal());
			// System.out.println("Cliente: " +
			// venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionário: " + venda.getFuncionario().getPessoa().getNome());

			venda.setHorario(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("30/12/2014 20:30:45"));
			venda.setValorTotal(new BigDecimal("1499.50"));
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);
			System.out.println();

			vendaDAO.editar(venda);

			System.out.println("Registro depois da edição:");
			System.out.println("Horário: " + venda.getHorario());
			System.out.println("Valor Total: " + venda.getValorTotal());
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionário: " + venda.getFuncionario().getPessoa().getNome());
		}
	}
}