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
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

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
		HttpSessionCsrfTokenRepository csrfTokenRepository=new HttpSessionCsrfTokenRepository();
		csrfTokenRepository.setHeaderName("XSRF-TOKEN");
		SimpleCORSFilter simpleCORSFilter=new SimpleCORSFilter();
		simpleCORSFilter.setCsrfTokenRepository(csrfTokenRepository);
		http
		.csrf().csrfTokenRepository(csrfTokenRepository).and()
		.addFilterBefore(simpleCORSFilter, ChannelProcessingFilter.class)
				.authorizeRequests()
				.antMatchers("/resources/**", "/signup", "/about","/api/**",
						"/apilogin**").permitAll().antMatchers("/admin/**")
				.hasRole("ADMIN").antMatchers("/db/**")
				.access("hasRole('ADMIN') and hasRole('DBA')")
				//.antMatchers("/api/**").hasRole("USER")
				.anyRequest()
				.authenticated().and().httpBasic().and().formLogin()
				.loginPage("/login").permitAll();

	}

}