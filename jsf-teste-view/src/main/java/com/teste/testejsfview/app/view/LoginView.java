package com.teste.testejsfview.app.view;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@ViewScoped
@Named
public class LoginView implements Serializable{
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 8898171064676601933L;
	
	private boolean recoverCodeSended;
	
	private String recoverUser;
	private LoginData data = new LoginData();
	
	
	public LoginData getData() {
		return data;
	}
	
	public void setData(LoginData data) {
		this.data = data;
	}
	
	public boolean isRecoverCodeSended() {
		return recoverCodeSended;
	}
	
	public void setRecoverCodeSended(boolean recoverCodeSended) {
		this.recoverCodeSended = recoverCodeSended;
	}

	
	public void sendCode() {
		recoverCodeSended = true;
		System.out.println("Teste");
	}
	
	public void resetRecover() {
	    recoverCodeSended = false;
	}

	public String getRecoverUser() {
		return recoverUser;
	}

	public void setRecoverUser(String recoverUser) {
		this.recoverUser = recoverUser;
	}
	
	
}
