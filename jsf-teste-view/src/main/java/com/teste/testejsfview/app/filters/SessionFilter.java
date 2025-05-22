package com.teste.testejsfview.app.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;


        String path = req.getRequestURI().substring(req.getContextPath().length());

        // Páginas públicas (ajuste conforme necessário)
        boolean paginaPublica = path.startsWith("/index.xhtml") || 
                                path.startsWith("/login.xhtml") ||
                                path.startsWith("/erroSessao.xhtml") ||
                                path.contains("javax.faces.resource"); // recursos JSF (CSS, JS, imagens)

        HttpSession session = req.getSession(false);

        if (paginaPublica || (session != null)) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
	}

}
