package br.com.alois.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.ItemVenda;
import br.com.alois.drogaria.domain.Produto;
import br.com.alois.drogaria.domain.Venda;

public class ItemVendaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigoProduto = 2L;
		Long codigoVenda = 4L;

		ItemVenda itemVenda = new ItemVenda();

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVenda);

		itemVenda.setQuantidade(new Short("14"));
		itemVenda.setValorParcial(new BigDecimal("489.36"));
		itemVenda.setProduto(produto);
		itemVenda.setVenda(venda);

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.salvar(itemVenda);

		System.out.println("Registro salvo com sucesso");
	}

	@Test
	@Ignore
	public void listar() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		List<ItemVenda> resultado = itemVendaDAO.listar();

		System.out.println("Total de registro encontrados: " + resultado.size());

		for (ItemVenda itemVenda : resultado) {
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preço Parcial: " + itemVenda.getValorParcial());
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Venda: " + itemVenda.getVenda().getCliente().getPessoa().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);

		if (itemVenda == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preço Parcial: " + itemVenda.getValorParcial());
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Venda: " + itemVenda.getVenda().getCliente().getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);

		if (itemVenda == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro a ser excluído:");
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preço Parcial: " + itemVenda.getValorParcial());
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Venda: " + itemVenda.getVenda().getCliente().getPessoa().getNome());

			itemVendaDAO.excluir(itemVenda);

			System.out.println("Registro excluído com sucesso.");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoItemVenda = 2L;
		Long codigoProduto = 2L;
		Long codigoVenda = 2L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigoItemVenda);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVenda);

		if (itemVenda == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro antes da edição:");
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preço Parcial: " + itemVenda.getValorParcial());
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Venda: " + itemVenda.getVenda().getCliente().getPessoa().getNome());
			System.out.println();

			itemVenda.setQuantidade(new Short("102"));
			itemVenda.setValorParcial(new BigDecimal("4650.89"));
			itemVenda.setProduto(produto);
			itemVenda.setVenda(venda);

			itemVendaDAO.editar(itemVenda);

			System.out.println("Registro após a edição:");
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preço Parcial: " + itemVenda.getValorParcial());
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Venda: " + itemVenda.getVenda().getCliente().getPessoa().getNome());
		}
	}
}