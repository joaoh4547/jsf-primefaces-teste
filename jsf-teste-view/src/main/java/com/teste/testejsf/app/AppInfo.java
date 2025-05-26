package com.teste.testejsf.app;

import java.time.Year;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("appInfo")
@ApplicationScoped
public class AppInfo {

	public int getCurrentYear() {
		return Year.now().getValue();
	}
	
	public String getAppName() {
		return "Demo App";
	}

}
