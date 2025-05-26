package com.teste.testejsf.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

	private static final Properties properties = new Properties();

	static {
		try (InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("application.properties")) {
			if (input != null) {
				properties.load(input);
			}
		} catch (IOException ex) {
			throw new RuntimeException("Erro carregando application.properties", ex);
		}
	}

	public static String getCliente() {
		return properties.getProperty("cliente", "default");
	}

}
