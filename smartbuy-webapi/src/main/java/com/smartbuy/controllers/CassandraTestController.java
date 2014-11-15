package com.smartbuy.controllers;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cassandratest")
public class CassandraTestController {

	@RequestMapping(value = "/commodity")
	public String getCommodities() {
		
		return "commodity";
	}
}
