package com.smartbuy.service;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DelphiService")
//@Secured("USER")
public class DelphiServiceController {
	
	@RequestMapping(value="/VehicleStatus")
	public VehicleStatus getStatus()
	{
		VehicleStatus status=new VehicleStatus();
		status.setLatitude(40);
		status.setLongtitude(-74);
		status.setSpeed(64);
		status.setRpm(2000);
		return status;
	}

}
