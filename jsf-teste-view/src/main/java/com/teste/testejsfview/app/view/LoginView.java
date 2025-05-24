package com.teste.testejsfview.app.view;

import java.io.Serializable;

import org.primefaces.PrimeFaces;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;

@Named
@SessionScoped()
public class LoginView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	@NotBlank(message = "{recoverUser.requiredUser.msg}")
	private String recoverUser;
	private String code;
	private String newPassword;
	private String repeatNewPassword;

	private boolean recoverCodeSended = false;

	// ==== Ações de Login ====
	public void login() {
		System.out.println("Fazendo login com " + username);
	}

	// ==== Ações de Recuperação ====
	public void sendCode() {
		recoverCodeSended = true;
		System.out.println("Código enviado para: " + recoverUser);
	}

	public void confirmRecover() {
		System.out.println("Recuperação confirmada para " + recoverUser);
		resetRecover();
		PrimeFaces.current().executeScript("PF('recoverPasswordDialog').hide()");
	}

	public void resetRecover() {
		recoverCodeSended = false;
		recoverUser = null;
		code = null;
		newPassword = null;
		repeatNewPassword = null;

		// Reset de validação
		PrimeFaces.current().resetInputs("recoverForm:recoverPanel");
	}

	// ==== Getters e Setters ====
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecoverUser() {
		return recoverUser;
	}

	public void setRecoverUser(String recoverUser) {
		this.recoverUser = recoverUser;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}

	public void setRepeatNewPassword(String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}

	public boolean isRecoverCodeSended() {
		return recoverCodeSended;
	}

	public void setRecoverCodeSended(boolean recoverCodeSended) {
		this.recoverCodeSended = recoverCodeSended;
	}
}
