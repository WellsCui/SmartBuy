package com.smartbuy.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class RestWebConfig extends WebMvcConfigurationSupport {

	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) { 
	    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	    List<MediaType> jsonTypes = new ArrayList<>(jsonConverter.getSupportedMediaTypes());
	    jsonTypes.add(MediaType.TEXT_PLAIN);
	    jsonConverter.setSupportedMediaTypes(jsonTypes);
	    converters.add(jsonConverter);
	}	
}