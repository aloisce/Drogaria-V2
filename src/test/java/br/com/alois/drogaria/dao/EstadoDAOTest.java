package br.com.alois.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Maceio");
		estado.setSigla("AL");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("Total de registros enconrtrados: " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 5L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());
		}
	}

	@Test
	public void editar() {
		Long codigo = 7L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());

			estado.setSigla("MG");
			estado.setNome("Minas Gerais");
			estadoDAO.editar(estado);

			System.out.println("Registro editado - depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + "-" + estado.getNome());
		}
	}
}
