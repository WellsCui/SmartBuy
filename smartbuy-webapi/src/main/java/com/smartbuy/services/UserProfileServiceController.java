package com.smartbuy.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.smartbuy.models.Greeting;
import com.smartbuy.models.UserProfile;

@RestController
//@RequestMapping(value = "/api/userprofile")
@Secured("USER")
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
	public Greeting GetGreeting() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		Greeting greeting = new Greeting();
		greeting.setUserProfile(getUserProfile(name));
		greeting.setGreetingMessage(String.format("Weclome %s!",greeting.getUserProfile().getFirstName()));
		return greeting;
	}
	
	private UserProfile getUserProfile(String name)
	{
		return userProfiles.get(0);
	}

}
