package br.com.alois.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Drogarça");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());
		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("O resultado da busca é:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro removido:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - antes:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());

			fabricante.setDescricao("Drogarça");
			fabricanteDAO.editar(fabricante);

			System.out.println("Registro editado - depois:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void merge() {
		// Fabricante fabricante = new Fabricante();
		// fabricante.setDescricao("Fabricante A");

		// FabricanteDAO fabricanteDAO = new FabricanteDAO();
		// fabricanteDAO.merge(fabricante);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(5L);

		fabricante.setDescricao("Fabricante B");
		fabricanteDAO.merge(fabricante);

	}
}