package com.smartbuy.services;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/")
public class AuthenticationController {
	
	private static final String CSRF_TOKEN_FOR_SESSION_ATTR_NAME = "_csrf";

	@RequestMapping(value="/accessToken",method=RequestMethod.GET)
	@ResponseBody
	public String getTokenForSession (HttpSession session) {
		 String token = null;
		 // I cannot allow more than one token on a session - in the case of two requests trying to
		 // init the token concurrently.
		 // Notice: in real life I wouldn't synchronize on the session instance. 
		 // This should be done on an attribute on the session. But for the 
		 // blog demo this is fine 
		   synchronized (session) {
		     token = (String) session.getAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME);
		     if (null==token) {
		       token=UUID.randomUUID().toString();
		       session.setAttribute(CSRF_TOKEN_FOR_SESSION_ATTR_NAME, token);
		   }
		 }
		 return token;
		}
}
