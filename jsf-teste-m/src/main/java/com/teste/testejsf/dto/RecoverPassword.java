package com.teste.testejsf.dto;

import jakarta.validation.constraints.NotBlank;

public class RecoverPassword {

	@NotBlank(message = "{recoverUser.requiredUser.msg}")
	private String userName;
	
	@NotBlank(message = "{recoverUser.requiredCode.msg}")
	private String verificationCode;
	
	@NotBlank(message = "{recoverUser.requiredNewPass.msg}")
	private String password;
	
	@NotBlank(message = "{recoverUser.requiredConfirmNewPass.msg}")
	private String confirmPassword;

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
