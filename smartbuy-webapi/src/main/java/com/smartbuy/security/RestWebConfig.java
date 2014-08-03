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
	public void configureMessageConverters(	List<HttpMessageConverter<?>> converters) {
		/*
		 * MappingJackson2HttpMessageConverter jsonConverter = new
		 * MappingJackson2HttpMessageConverter(); List<MediaType> jsonTypes =
		 * new ArrayList<>(jsonConverter.getSupportedMediaTypes());
		 * jsonTypes.add(MediaType.TEXT_PLAIN);
		 * jsonConverter.setSupportedMediaTypes(jsonTypes);
		 * converters.add(jsonConverter);
		 */

		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType(
				"text", "plain", UTF8)));
		converters.add(stringConverter);

		// Add other converters ...

	}
}