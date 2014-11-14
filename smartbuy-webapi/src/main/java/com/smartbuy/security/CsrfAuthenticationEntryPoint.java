package com.smartbuy.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.ELRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
 
/**
 * @author bchild
 *
 */
public class CsrfAuthenticationEntryPoint implements
AuthenticationEntryPoint {
	
	private static final RequestMatcher requestMatcher = new ELRequestMatcher(
			"hasHeader('X-Requested-With','XMLHttpRequest')");	
	
	public CsrfAuthenticationEntryPoint() {
	
	}	
	
	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
        if(isPreflight(request)){
        	response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        	response.setHeader("Access-Control-Allow-Origin", "*");	

    		response.setHeader("Access-Control-Allow-Credentials", "true");
    		response.setHeader("Access-Control-Allow-Methods",
    				"POST, GET, OPTIONS, DELETE");
    		response.setHeader("Access-Control-Max-Age", "3600");
    		response.setHeader("Access-Control-Allow-Headers",
    				"x-requested-with,authorization,X-XSRF-TOKEN,XSRF-TOKEN");
        }         
        else {
        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }
    }
	
	/**
   * Checks if this is a X-domain pre-flight request.
	 * @param request
	 * @return
	 */
	private boolean isPreflight(HttpServletRequest request) {
		return "OPTIONS".equals(request.getMethod());
	}
 
	/**
	 * Checks if it is a rest request
	 * @param request
	 * @return
	 */
	protected boolean isRestRequest(HttpServletRequest request) {
		return requestMatcher.matches(request);
	}
}