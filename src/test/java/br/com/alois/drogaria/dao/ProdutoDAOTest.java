package br.com.alois.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Fabricante;
import br.com.alois.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("2"));

		Produto produto = new Produto();
		produto.setDescricao("Cabeciudo gotas 50ml");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("3.90"));
		produto.setQuantidade(new Short("4"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("Produto salvo com sucesso");
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Produto produto : resultado) {
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 8L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Produto não encontrado");
		} else {
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Produto não encontrado");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Registro removido:");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getDescricao());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoProduto = 3L;
		Long codigoFabricante = 3L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);

		if (produto == null) {
			System.out.println("Registro não encontrado");
		} else {

			System.out.println("Registro antes da edição:");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getDescricao());
			System.out.println("");

			produto.setDescricao("Beiçinos 15mg com 33 comprimidos");
			produto.setQuantidade(new Short("24"));
			produto.setPreco(new BigDecimal("22.30"));
			produto.setFabricante(fabricante);

			produtoDAO.editar(produto);

			System.out.println("Registro depois da Edição:");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getDescricao());
		}
	}
}