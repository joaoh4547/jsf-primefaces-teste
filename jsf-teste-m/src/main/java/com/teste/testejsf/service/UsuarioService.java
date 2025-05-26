package com.teste.testejsf.service;

import java.util.List;

import com.teste.testejsf.model.Usuario;
import com.teste.testejsf.persistence.UsuarioRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioService {
	@Inject
	private UsuarioRepository repository;

	@Transactional
	public void salvar(Usuario usuario) {
		repository.salvar(usuario);
	}

	@Transactional
	public void excluir(Usuario usuario) {
		repository.remover(usuario);
	}

	public List<Usuario> listar() {
		return repository.listar();
	}
}
