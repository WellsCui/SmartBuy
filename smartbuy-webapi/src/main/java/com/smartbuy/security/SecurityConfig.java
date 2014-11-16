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

	@Bean
	public CsrfTokenValidator getCsrfTokenValidator() {
		if (csrfTokenRepository == null) {
			csrfTokenRepository = new HttpHeaderCsrfTokenValidator();
			csrfTokenRepository.setHeaderName("X-XSRF-TOKEN");
		}
		return csrfTokenRepository;
	}

	private static HttpHeaderCsrfTokenValidator csrfTokenRepository;

	protected void configure(HttpSecurity http) throws Exception {
		CsrfTokenValidator repo = getCsrfTokenValidator();
		SimpleCORSFilter simpleCORSFilter = new SimpleCORSFilter();
		simpleCORSFilter.setCsrfTokenRepository(repo);
		http.csrf()
				.csrfTokenRepository(repo)
				.and()
				.addFilterBefore(simpleCORSFilter,ChannelProcessingFilter.class)
				.authorizeRequests()
				.antMatchers("/resources/**", "/", "/about", "/api/login","/cassandratest/**").permitAll()
				.antMatchers("/api/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/db/**")
				.access("hasRole('ADMIN') and hasRole('DBA')")				
				.anyRequest().authenticated().and().httpBasic()
				.authenticationEntryPoint(new CsrfAuthenticationEntryPoint())
				.and().formLogin().loginPage("/login").permitAll()
				;

	}

}