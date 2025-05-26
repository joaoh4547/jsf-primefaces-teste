package com.teste.testejsf.persistence;

import java.util.List;

import com.teste.testejsf.model.Usuario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class UsuarioRepository {
	@PersistenceContext
	private EntityManager em;

	public List<Usuario> listar() {
		return em.createQuery("FROM Usuario", Usuario.class).getResultList();
	}

	public void salvar(Usuario usuario) {
		if (usuario.getId() == null) {
			em.persist(usuario);
		} else {
			em.merge(usuario);
		}
	}

	public void remover(Usuario usuario) {
		em.remove(em.contains(usuario) ? usuario : em.merge(usuario));
	}
}
