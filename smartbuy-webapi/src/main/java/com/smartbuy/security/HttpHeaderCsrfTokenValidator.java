package com.smartbuy.security;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.util.Assert;

public class HttpHeaderCsrfTokenValidator implements CsrfTokenValidator {

    private static final String DEFAULT_CSRF_HEADER_NAME = "X-CSRF-TOKEN";
    private static final String LOGIN_URI = "/API/LOGIN";
    
    private String headerName = DEFAULT_CSRF_HEADER_NAME;
    
    private Map<String,String> userToken;
    

    public HttpHeaderCsrfTokenValidator()
    {
    	userToken=new ConcurrentHashMap<String,String>();
    }
    /*
     * (non-Javadoc)
     * @see org.springframework.security.web.csrf.CsrfTokenRepository#saveToken(org.springframework.security.web.csrf.CsrfToken, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void saveToken(CsrfToken token, HttpServletRequest request,
            HttpServletResponse response) {
        if (token == null) {
        	response.setHeader(headerName, "");            
        } else {
        	response.setHeader(headerName, token.getToken());
        }
    }

    /* (non-Javadoc)
     * @see org.springframework.security.web.csrf.CsrfTokenRepository#loadToken(javax.servlet.http.HttpServletRequest)
     */
    public CsrfToken loadToken(HttpServletRequest request) {   	
    	    	
        String token=request.getHeader(headerName);
        if (token==null ||token.isEmpty())
        	return null;
        return new DefaultCsrfToken(headerName, headerName, token);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.web.csrf.CsrfTokenRepository#generateToken(javax.servlet.http.HttpServletRequest)
     */
    public CsrfToken generateToken(HttpServletRequest request) {
        return new DefaultCsrfToken(headerName, headerName, createNewToken());
    }
    
    /**
     * Sets the header name that the {@link CsrfToken} is expected to appear on
     * and the header that the response will contain the {@link CsrfToken}.
     *
     * @param headerName
     *            the new header name to use
     */
    public void setHeaderName(String headerName) {
        Assert.hasLength(headerName, "headerName cannot be null or empty");
        this.headerName = headerName;
    }

    private String createNewToken() {
        return UUID.randomUUID().toString();
    }

	@Override
	public boolean Validate(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest) req;
		String requestUri=request.getRequestURI();
		String method=request.getMethod().toUpperCase();
		if (requestUri.toUpperCase().endsWith(LOGIN_URI) || method.equals("OPTIONS"))
			return true;
		CsrfToken token= loadToken(request);
		if (token==null)
			return false;
		return (userToken.containsValue(token.getToken()));		
	}

	@Override
	public void RegisterCsrfToken(String User, String csrfToken) {
		userToken.put(User, csrfToken);
		
	}

}
