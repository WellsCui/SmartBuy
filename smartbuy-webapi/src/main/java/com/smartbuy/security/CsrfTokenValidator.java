package com.smartbuy.security;

import javax.servlet.ServletRequest;

import org.springframework.security.web.csrf.CsrfTokenRepository;

public interface CsrfTokenValidator extends CsrfTokenRepository  {
	public boolean Validate( ServletRequest req);
	public void RegisterCsrfToken(String User,String csrfToken);
}
