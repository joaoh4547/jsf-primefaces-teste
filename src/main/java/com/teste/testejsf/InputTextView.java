package com.teste.testejsf;


import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class InputTextView {

	 private String text;

	    public String getText() {
	    	Object value = """
	    			dsdsd
	    			dsdsd
	    			""";
	        return text;
	    }

	    public void setText(String text) {
	        this.text = text;
	    }
	
}
