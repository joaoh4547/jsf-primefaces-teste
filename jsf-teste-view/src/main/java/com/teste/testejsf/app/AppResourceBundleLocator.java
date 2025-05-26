package com.teste.testejsf.app;

import java.util.Locale;
import java.util.ResourceBundle;

import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;

public class AppResourceBundleLocator implements ResourceBundleLocator{

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		return new ApplicationResourceBundle().getBundle();
	}
	
	

}
