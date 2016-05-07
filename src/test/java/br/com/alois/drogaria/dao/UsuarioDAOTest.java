package br.com.alois.drogaria.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.alois.drogaria.domain.Pessoa;
import br.com.alois.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Long codigoPessoa = 3L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		System.out.println("Pessoa encontrada:");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());

		Usuario usuario = new Usuario();
		usuario.setSenhaSemCriptografia("q1w2e3r4");
		
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		usuario.setSenha(hash.toHex());
		
		usuario.setTipo('G');
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		System.out.println("Usuário salvo com sucesso.");
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		System.out.println("Registros encontrados: " + resultado.size());

		for (Usuario usuario : resultado) {
			System.out.println("Senha: ************");
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Senha: ************");
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro econtrado para exclusão:");
			System.out.println("Senha: *************");
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa().getNome());

			usuarioDAO.excluir(usuario);

			System.out.println("Usuário excluído com sucesso.");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoUsuario = 3L;
		Long codigoPessoa = 2L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		if (usuario == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro a ser editado:");

			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa().getNome());
			System.out.println();

			usuario.setSenha("q1w2e3r5");
			usuario.setTipo('B');
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);

			usuarioDAO.editar(usuario);

			System.out.println("Registro após edição:");

			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Pessoa: " + usuario.getPessoa().getNome());
			System.out.println();
		}
	}
	
	@Test
	public void autenticar(){
		String cpf = "255.697.569-89";
		String senha = "q1w2e3r4";
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.autenticar(cpf, senha);
		
		System.out.println("Usuário autenticado: " + usuario);
	}
}