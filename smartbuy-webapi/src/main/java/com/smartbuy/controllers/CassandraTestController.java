package com.smartbuy.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartbuy.dao.SmartBuyDao;
import com.smartbuy.entities.Address;
import com.smartbuy.entities.Shopping;
import com.smartbuy.services.DelphiService;

@RestController
@RequestMapping(value = "cassandratest")
public class CassandraTestController {

	SmartBuyDao smartBuyDao;
	
	@Autowired
	public void setSmartBuyDao(SmartBuyDao smartBuyDao) {
		this.smartBuyDao = smartBuyDao;
	}
	
	@RequestMapping(value = "/shopping")
	public Shopping[] getCommodities() {
		
		ArrayList<Shopping> list= (ArrayList<Shopping>)
				smartBuyDao.findByQuery("select s from Shopping s where s.customerId='customerId001' and s.createdTime<:createdTime",
						"createdTime",new Date());		
		
		//Shopping shopping= smartBuyDao.findById(Shopping.class, "shopping001");
		return list.toArray(new Shopping[list.size()]);		
	}
	
	@RequestMapping(value = "/Shopping/create")
	public Shopping createShopping() {
		Shopping shopping= new Shopping();
		shopping.setId(UUID.randomUUID().toString());
		shopping.setAmount(102.5);
		Address billingAddress=new Address();
		billingAddress.setCountry("Canada");
		billingAddress.setCity("Ottawa");
		billingAddress.setStreet("St-Jacques");
		billingAddress.setStreetNumber(271);
		billingAddress.setUnit("C");
		billingAddress.setZipcode("K1L5G6");
		shopping.setBillingAddress(billingAddress);
		shopping.setShippingAddress(billingAddress);
		shopping.setCreatedTime(new Date());
		shopping.setCustomerId("customerId001");
		smartBuyDao.insert(shopping);		
		return shopping;
	}
}
