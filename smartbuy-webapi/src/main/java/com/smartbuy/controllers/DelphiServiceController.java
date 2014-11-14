package com.smartbuy.controllers;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.smartbuy.domain.*;
import com.smartbuy.services.DelphiService;


@RestController
@RequestMapping(value="/api/DelphiService")
@Secured("ROLE_ADMIN")
public class DelphiServiceController {

	DelphiService delphiService;
	
	@Autowired
	public void setDelphiService(DelphiService delphiService) {
		this.delphiService = delphiService;
	}

	@RequestMapping(value="/VehicleStatus",method=RequestMethod.GET)
	//@ResponseBody
	public  VehicleStatus GetStatus()
	{		
		return delphiService.GetStatus();
	}
	
	@RequestMapping(value="/VehicleStatus",method=RequestMethod.POST
		//	,consumes={"text/plain", "application/*"}
	)
	//@ResponseBody
	public  VehicleStatus UpdateStatus(@RequestBody VehicleStatus vehicleStatus)
	//public  VehicleStatus UpdateStatus(@RequestBody String status) throws JsonParseException, JsonMappingException, IOException
	{
		return delphiService.UpdateStatus(vehicleStatus);
	}
	
	
}
