package br.com.alois.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Cidade;
import br.com.alois.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigo = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(codigo);

		Cidade cidade = new Cidade();
		cidade.setNome("Arneiros");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getCodigo()
					+ " - " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getCodigo()
				+ " - " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		cidadeDAO.excluir(cidade);
		System.out.println("Cidade removida");
		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getCodigo()
				+ " - " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoCidade = 1L;
		Long codigoEstado = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);

		System.out.println("Dados do Estado");
		System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		System.out.println("Cidade a ser editada");
		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getCodigo()
				+ " - " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());

		cidade.setNome("Guarapuava");
		cidade.setEstado(estado);

		cidadeDAO.editar(cidade);

		System.out.println("Cidade editada");
		System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getCodigo()
				+ " - " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
	}

	@Test
	@Ignore
	public void buscarPorEstado() {
		Long estadoCodigo = 1L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);

		for (Cidade cidade : resultado) {
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getCodigo()
					+ " - " + cidade.getEstado().getSigla() + " - " + cidade.getEstado().getNome());
		}
	}
}