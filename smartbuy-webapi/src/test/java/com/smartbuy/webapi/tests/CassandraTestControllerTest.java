package com.smartbuy.webapi.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartbuy.controllers.CassandraTestController;
import com.smartbuy.controllers.DelphiServiceController;
import com.smartbuy.dao.SmartBuyDao;
import com.smartbuy.domain.*;
import com.smartbuy.entities.Shopping;
import com.smartbuy.security.RestWebConfig;
import com.smartbuy.security.SecurityConfig;
import com.smartbuy.services.DelphiService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		SecurityConfig.class,
		RestWebConfig.class,       
})
@WebAppConfiguration
public class CassandraTestControllerTest {
	MockMvc mockMvc;

	  @InjectMocks
	  CassandraTestController controller;

	  @Mock
	  SmartBuyDao smartBuyDao;

	  UUID key = UUID.fromString("f3512d26-72f6-4290-9265-63ad69eccc14");

	  @Before
	  public void setup() {
	    MockitoAnnotations.initMocks(this);

	    this.mockMvc = standaloneSetup(controller)
	            .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	  }
	  
	  @Test
	  public void whenGetShopping_ShouldReturn() throws Exception {		 		
			
		List<Shopping> shoppings=new ArrayList<Shopping>();
		shoppings.add(new Shopping());
		shoppings.add(new Shopping());
		shoppings.toArray(new Shopping[2]);
		String query="select s from Shopping s where s.customerid='customerId001' and s.createdTime<:createdTime";
		Mockito.doReturn(shoppings).when(smartBuyDao).findByQuery(Mockito.eq(query),Mockito.eq("createdTime"),Mockito.any());

	    String body=this.mockMvc.perform(
	            get("/cassandratest/shopping")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
	    
	    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	    Shopping[] result = mapper.readValue(body, (new Shopping[0]).getClass());
	    Assert.assertEquals(2, result.length);    
	    
	    
	  }
	  
}
