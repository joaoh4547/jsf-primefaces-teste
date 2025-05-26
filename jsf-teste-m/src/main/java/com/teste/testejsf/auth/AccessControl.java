package com.teste.testejsf.auth;

import com.teste.testejsf.BaseBean;
import com.teste.testejsf.model.Usuario;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@SessionScoped
@Named
public class AccessControl extends BaseBean {

	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1108473789624392880L;
	private Usuario currentUser;
	
	public Usuario getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(Usuario currentUser) {
		this.currentUser = currentUser;
	}
	
}
