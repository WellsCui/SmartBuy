package com.smartbuy.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Component;

//@Component
public class SimpleCORSFilter implements Filter {
	// @Autowired
	private CsrfTokenValidator csrfTokenValidator;

	public void setCsrfTokenRepository(CsrfTokenValidator csrfTokenValidator) {
		this.csrfTokenValidator = csrfTokenValidator;
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if (!csrfTokenValidator.Validate(request))
			throw new ServletException("Invalid Csrf Token!");
		response.setHeader("Access-Control-Allow-Origin", "*");	

		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with,authorization,X-XSRF-TOKEN,XSRF-TOKEN");

		chain.doFilter(req, res);
	}	

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}