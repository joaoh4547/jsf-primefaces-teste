package com.teste.testejsf.app;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ApplicationResourceBundle extends ResourceBundle {

	private ResourceBundle bundle;
	private ResourceBundle defaultBundle;

	public ApplicationResourceBundle() {

	}

	private ResourceBundle getDefaultBundle() {
		if (defaultBundle == null) {
			defaultBundle = getBundleByName("messages");
		}
		return defaultBundle;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (getBundle() == null && getDefaultBundle() == null) {
			return "???" + key + "???";
		}
		try {
			return getBundle().getString(key);
		} catch (MissingResourceException e) {
			try {
				return getDefaultBundle().getString(key);
			} catch (Exception e2) {
				return "???" + key + "???";
			}

		}
	}

	public ResourceBundle getBundle() {
		if (bundle == null) {
			// Tenta carregar o bundle específico do cliente
			try {
				bundle = getBundleByName("messages_" + getClienteAtual());
			} catch (MissingResourceException e) {
				// Se não achar, usa o bundle padrão
				bundle = getDefaultBundle();
			}
		}
		return bundle;
	}

	private ResourceBundle getBundleByName(String nome) {
		ResourceBundle bundle = ResourceBundle.getBundle(nome);
		return bundle;
	}

	@Override
	public Enumeration<String> getKeys() {
		List<String> keys = new ArrayList<>();

		if (getBundle() != null)
			getBundle().getKeys().asIterator().forEachRemaining(keys::add);
		if (getDefaultBundle() != null)
			getDefaultBundle().getKeys().asIterator().forEachRemaining(keys::add);

		return java.util.Collections.enumeration(keys);
	}

	private String getClienteAtual() {
		return AppConfig.getCliente();
	}

}
