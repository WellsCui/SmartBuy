package com.smartbuy.webapi.tests;

import java.util.UUID;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
import com.smartbuy.controllers.DelphiServiceController;
import com.smartbuy.models.VehicleStatus;
import com.smartbuy.security.RestWebConfig;
import com.smartbuy.security.SecurityConfig;
import com.smartbuy.services.DelphiService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		SecurityConfig.class,
		RestWebConfig.class,       
})
@WebAppConfiguration
public class DelphiServiceControllerIntegrationTest {
	MockMvc mockMvc;

	  @InjectMocks
	  DelphiServiceController controller;

	  @Mock
	  DelphiService delphiService;

	  UUID key = UUID.fromString("f3512d26-72f6-4290-9265-63ad69eccc13");

	  @Before
	  public void setup() {
	    MockitoAnnotations.initMocks(this);

	    this.mockMvc = standaloneSetup(controller)
	            .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	  }
	  
	  @Test
	  public void whenGetStatus_ShouldReturn() throws Exception {

		  VehicleStatus status=new VehicleStatus();
			status.setLatitude(20.1);
			status.setLongtitude(30);
			status.setSpeed(40);
			status.setRmp(10);		
			
	    when(delphiService.GetStatus()).thenReturn(status);

	    String body=this.mockMvc.perform(
	            get("/api/DelphiService/VehicleStatus")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isOk())
	            .andReturn().getResponse().getContentAsString();
	    
	    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	    VehicleStatus returnStatus = mapper.readValue(body, VehicleStatus.class);
	    Assert.assertEquals(status.getLatitude(), returnStatus.getLatitude());
	    Assert.assertEquals(status.getLongtitude(), returnStatus.getLongtitude());
	    Assert.assertEquals(status.getSpeed(), returnStatus.getSpeed());
	    Assert.assertEquals(status.getRmp(), returnStatus.getRmp());
	    
	    
	  }
	  
}
