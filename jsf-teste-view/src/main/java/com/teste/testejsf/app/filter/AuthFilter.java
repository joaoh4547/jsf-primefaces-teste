package com.teste.testejsf.app.filter;

import java.io.IOException;

import com.teste.testejsf.auth.AccessControl;

import jakarta.inject.Inject;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AuthFilter implements Filter {

	@Inject
	private AccessControl control;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String path = req.getRequestURI().substring(req.getContextPath().length());

		// Páginas públicas (ajuste conforme necessário)
		boolean paginaPublica = path.startsWith("/login.xhtml") || path.contains("jakarta.faces.resource") || path.contains("javax.faces.resource") ;

//		var context = CDI.current();

//		control = context.

		if (paginaPublica) {
			chain.doFilter(request, response);
		}

		else if (control.getCurrentUser() == null) {
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
		} else {
			chain.doFilter(request, response);
		}

	}

}
