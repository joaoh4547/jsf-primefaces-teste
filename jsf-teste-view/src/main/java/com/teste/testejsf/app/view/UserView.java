package com.teste.testejsf.app.view;

import java.util.List;

import com.teste.testejsf.BaseBean;
import com.teste.testejsf.model.Usuario;
import com.teste.testejsf.service.UsuarioService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class UserView extends BaseBean {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6759152383335219656L;

	@Inject
	private UsuarioService service;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	@PostConstruct
	public void init() {
		usuarios = service.listar();
	}

	public void salvar() {
		service.salvar(usuario);
		usuarios = service.listar();
		usuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário salvo com sucesso"));
	}

	public void excluir(Usuario usuario) {
		service.excluir(usuario);
		usuarios = service.listar();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário excluído com sucesso"));
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
