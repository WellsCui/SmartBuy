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
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Component;

//@Component
public class SimpleCORSFilter implements Filter {
	//@Autowired
	private CsrfTokenRepository csrfTokenRepository;
	
	public CsrfTokenRepository getCsrfTokenRepository() {
		return csrfTokenRepository;
	}

	public void setCsrfTokenRepository(CsrfTokenRepository csrfTokenRepository) {
		this.csrfTokenRepository = csrfTokenRepository;
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		
		
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		//response.
		if (loadCsrfToken(request)==null)		
		{
			CsrfToken token=csrfTokenRepository.generateToken(request);
			csrfTokenRepository.saveToken(token,request,response);
			Cookie tokenCookie=new Cookie(token.getHeaderName(),token.getToken());			
			response.addCookie(tokenCookie);		    
		}
		
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,authorization,X-XSRF-TOKEN");
		
		chain.doFilter(req, res);
	}
	
	private CsrfToken loadCsrfToken(HttpServletRequest request)
	{	
		Cookie[] cookies = request.getCookies();
		if (cookies==null || cookies.length==0) return null;
		CsrfToken token= csrfTokenRepository.generateToken(request);
		for (Cookie cookie:cookies)
		{
			if (cookie.getName().equals(token.getHeaderName()))
			{
				return new DefaultCsrfToken(token.getHeaderName(), token.getParameterName(), cookie.getValue());				
			}
		}
		return null;
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}