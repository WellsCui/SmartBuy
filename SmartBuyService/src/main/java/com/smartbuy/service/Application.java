package com.smartbuy.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.smartbuy.config.WebAppInitializer;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);
    	//app.addInitializers(new WebAppInitializer());
    	
    	app.run(args);   	
    }
}
