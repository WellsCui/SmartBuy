package com.smartbuy.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartbuy.dao.SmartBuyDao;
import com.smartbuy.entities.shopping;
import com.smartbuy.services.DelphiService;

@RestController
@RequestMapping(value = "cassandratest")
public class CassandraTestController {

	SmartBuyDao smartBuyDao;
	
	@Autowired
	public void setSmartBuyDao(SmartBuyDao smartBuyDao) {
		this.smartBuyDao = smartBuyDao;
	}
	
	@RequestMapping(value = "/commodity")
	public String getCommodities() {
		//List<?> list=smartBuyDao.findByQuery("select * from shopping");
		shopping shopping= smartBuyDao.findById(shopping.class, "shopping001");
		return "commodity";
	}
}
