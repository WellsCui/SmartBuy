package com.smartbuy.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password")
				.roles("USER");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().addFilterBefore(new SimpleCORSFilter(),ChannelProcessingFilter.class)
		.authorizeRequests()	
		 .antMatchers("/resources/**", "/signup", "/about","/api/**").permitAll()
		 .antMatchers("/admin/**").hasRole("ADMIN") .antMatchers("/db/**")
		 .access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
		 
		.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.permitAll();
	}	
	
}