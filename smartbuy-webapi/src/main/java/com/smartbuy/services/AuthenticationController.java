package com.smartbuy.services;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apilogin")
public class AuthenticationController {
	private AuthenticationManager authenticationManager;
	
	private static final String CSRF_TOKEN_FOR_SESSION_ATTR_NAME = "_csrf";
	 @Autowired
	    public void setAuthenticationManager(AuthenticationManager authenticationManager){
	        this.authenticationManager=authenticationManager;
	    }
	 
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String login (
			@RequestParam String loginType,
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String oauthToken,			
			HttpSession session) {
		 String token = null;
		 // I cannot allow more than one token on a session - in the case of two requests trying to
		 // init the token concurrently.
		 // Notice: in real life I wouldn't synchronize on the session instance. 
		 // This should be done on an attribute on the session. But for the 
		 // blog demo this is fine
		 
		 UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		 Authentication auth= authenticationManager.authenticate(authRequest);
		 
		 if (auth.isAuthenticated())
		 {
			   synchronized (session) {
			     token = (String) session.getAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME);
			     if (null==token) {
			       token=UUID.randomUUID().toString();
			       session.setAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME, token);
			   }
			 }
		 }
		 return token;
		}
}
