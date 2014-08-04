package com.smartbuy.security;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RestWebConfig extends WebMvcConfigurerAdapter {
	private static final Charset UTF8 = Charset.forName("UTF-8");

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		//stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("TEXT","PLAIN",UTF8)));
		stringConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON));
		
		converters.add(stringConverter);
		
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();		
		jsonConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON));
		converters.add(jsonConverter);

		// Add other converters ...

	}
}