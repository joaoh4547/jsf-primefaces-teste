package com.teste.testejsf.app.view;

import java.util.ResourceBundle;

import org.primefaces.PrimeFaces;

import com.teste.testejsf.BaseBean;
import com.teste.testejsf.auth.AccessControl;
import com.teste.testejsf.dto.AuthDTO;
import com.teste.testejsf.dto.RecoverPassword;
import com.teste.testejsf.model.Usuario;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginView extends BaseBean {

	private static final long serialVersionUID = 1L;

	private AuthDTO auth = new AuthDTO();

	private RecoverPassword recoverPassword = new RecoverPassword();

	private int activeIndex = 0;
	
	@Inject
	private AccessControl control;
	

	public void sendCode() {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		if ("admin".equalsIgnoreCase(recoverPassword.getUserName())) {
//			facesContext.addMessage("recoverUser", new FacesMessage(FacesMessage.SEVERITY_ERROR,
//					"Usuário 'admin' não é permitido para recuperação.", null));
			facesContext.addMessage("recoverUser", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Teste 'admin' não é permitido para recuperação.", null));
			return;
		}
		activeIndex++;
//
//		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
//				"Código enviado para " + recoverPassword.getUserName(), null));
	}

	public void resetRecover() {
		activeIndex = 0;
		recoverPassword = new RecoverPassword();
	}

	public void confirmRecover() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msg");
		if (!recoverPassword.getConfirmPassword().equals(recoverPassword.getPassword())) {
			facesContext.addMessage("confirmPass",
					new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("senhasNaocoincidem.msg"), null));
			return;
		} else {
			recoverPassword = new RecoverPassword();
			activeIndex = 0;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Senha alterada com sucesso."));

			PrimeFaces.current().executeScript("PF('recoverDialog').hide();");

			PrimeFaces.current().ajax().update("growl");
		}
	}

	public RecoverPassword getRecoverPassword() {
		return recoverPassword;
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}

	public void setRecoverPassword(RecoverPassword recoverPassword) {
		this.recoverPassword = recoverPassword;
	}

	public AuthDTO getAuth() {
		return auth;
	}

	public void setAuth(AuthDTO auth) {
		this.auth = auth;
	}
	
	public String login() {
		Usuario u = new Usuario();
		u.setNome(auth.getUsername());
		u.setSenha(auth.getPlainPassword());
		control.setCurrentUser(u);
		return "/index.xhtml?faces-redirect=true";
	}
}
