package com.smartbuy.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);
    	//app.addInitializers(new WebAppInitializer());
    	
    	app.run(args);   	
    }
}
