package br.com.alois.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Cidade;
import br.com.alois.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	@Ignore
	public void salvar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(new Long("1"));

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Dimaria da conceição Reis");
		pessoa.setCpf("515.456.698-82");
		pessoa.setRg("326597");
		pessoa.setRua("Av. Sebastião Negreiros");
		pessoa.setNumero(new Short("33"));
		pessoa.setBairro("Jaboatão");
		pessoa.setCep("56-569");
		pessoa.setComplemento("APTO-24");
		pessoa.setTelefone("(77)7777-7777");
		pessoa.setCelular("(77)7777-7777");
		pessoa.setEmail("test@gmail.com");
		pessoa.setCidade(cidade);

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

		System.out.println("Registro salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		System.out.println("Total de registros listados: " + resultado.size());
		System.out.println("");

		for (Pessoa pessoa : resultado) {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Endereço : " + pessoa.getNome() + ", Nº" + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("CEP: " + pessoa.getCep() + "  Bairro: " + pessoa.getBairro());
			System.out.println("Cidade: " + pessoa.getCidade().getNome() + "  E-mail: " + pessoa.getEmail());
			System.out.println("CPF: " + pessoa.getCpf() + "  RG:" + pessoa.getRg());
			System.out.println("Telefone Fixo: " + pessoa.getTelefone() + "  Celular: " + pessoa.getCelular());
			System.out.println("");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Endereço : " + pessoa.getNome() + ", Nº" + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("CEP: " + pessoa.getCep() + "  Bairro: " + pessoa.getBairro());
			System.out.println("Cidade: " + pessoa.getCidade().getNome() + "  E-mail: " + pessoa.getEmail());
			System.out.println("CPF: " + pessoa.getCpf() + "  RG:" + pessoa.getRg());
			System.out.println("Telefone Fixo: " + pessoa.getTelefone() + "  Celular: " + pessoa.getCelular());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Registro não encontrado!");
		} else {
			pessoaDAO.excluir(pessoa);
			System.out.println("Registro removido:");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Endereço : " + pessoa.getNome() + ", Nº" + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("CEP: " + pessoa.getCep() + "  Bairro: " + pessoa.getBairro());
			System.out.println("Cidade: " + pessoa.getCidade().getNome() + "  E-mail: " + pessoa.getEmail());
			System.out.println("CPF: " + pessoa.getCpf() + "  RG:" + pessoa.getRg());
			System.out.println("Telefone Fixo: " + pessoa.getTelefone() + "  Celular: " + pessoa.getCelular());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoPessoa = 1L;
		Long codigoCidade = 2L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		if (pessoa == null) {
			System.out.println("Registro não encontrado");
		} else {
			System.out.println("Registro antes da edição:");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Endereço : " + pessoa.getNome() + ", Nº" + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("CEP: " + pessoa.getCep() + "  Bairro: " + pessoa.getBairro());
			System.out.println("Cidade: " + pessoa.getCidade().getNome() + "  E-mail: " + pessoa.getEmail());
			System.out.println("CPF: " + pessoa.getCpf() + "  RG:" + pessoa.getRg());
			System.out.println("Telefone Fixo: " + pessoa.getTelefone() + "  Celular: " + pessoa.getCelular());

			pessoa.setNome("Ardelino da Conceição dos Reis");
			pessoa.setCpf("255.697.569-89");
			pessoa.setRg("12456789");
			pessoa.setRua("Travessa Três Irmãos");
			pessoa.setNumero(new Short("55"));
			pessoa.setBairro("Das Lavadeiras");
			pessoa.setCep("65-456");
			pessoa.setComplemento("Altos");
			pessoa.setTelefone("(11)1111-1111");
			pessoa.setCelular("(11)1111-1111");
			pessoa.setEmail("judalulu@gmail.com");
			pessoa.setCidade(cidade);

			pessoaDAO.editar(pessoa);

			System.out.println("");
			System.out.println("Registro editado:");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Endereço : " + pessoa.getNome() + ", Nº" + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("CEP: " + pessoa.getCep() + "  Bairro: " + pessoa.getBairro());
			System.out.println("Cidade: " + pessoa.getCidade().getNome() + "  E-mail: " + pessoa.getEmail());
			System.out.println("CPF: " + pessoa.getCpf() + "  RG:" + pessoa.getRg());
			System.out.println("Telefone Fixo: " + pessoa.getTelefone() + "  Celular: " + pessoa.getCelular());
		}
	}
}