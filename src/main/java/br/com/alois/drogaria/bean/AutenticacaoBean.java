package br.com.alois.drogaria.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.alois.drogaria.dao.UsuarioDAO;
import br.com.alois.drogaria.domain.Pessoa;
import br.com.alois.drogaria.domain.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		usuario.setPessoa(new Pessoa());
	}
	
	public void autenticar(){
		try{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioLogado =  usuarioDAO.autenticar(usuario.getPessoa().getCpf(), usuario.getSenha());
			
		if(usuarioLogado == null){
			Messages.addGlobalError("CPF e/ou senha incorretos");
			return;
		}
		
		Faces.redirect("./pages/principal.xhtml");
		}catch (IOException erro){
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
}
