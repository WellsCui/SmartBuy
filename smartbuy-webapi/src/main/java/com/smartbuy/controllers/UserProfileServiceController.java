package com.smartbuy.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.smartbuy.domain.Greeting;
import com.smartbuy.domain.UserProfile;
import com.smartbuy.security.SecurityConfig;

@RestController
//@RequestMapping(value = "/api/userprofile")
//@Secured("USER")
public class UserProfileServiceController {
	static List<UserProfile> userProfiles;
	
	static 
	{
		userProfiles=new ArrayList<UserProfile>();
		UserProfile up= new UserProfile();
		up.setUserName("user");
		up.setPassword("password");
		up.setFirstName("Wei");
		up.setLastName("Cui");		
		userProfiles.add(up);
	}

	@RequestMapping(value = "/api/greeting", method = RequestMethod.GET)
	// @ResponseBody
	//@Secured("USER")
	public Greeting GetGreeting(ServletRequest req, ServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		
		String name = auth.getName();
		Greeting greeting = new Greeting();
		greeting.setUserProfile(getUserProfile(name));
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//greeting.setAccessToken(response.);
		
		greeting.setGreetingMessage(String.format("Weclome %s!",greeting.getUserProfile().getFirstName()));
		return greeting;
	}
	
	private UserProfile getUserProfile(String name)
	{
		return userProfiles.get(0);
	}

}
