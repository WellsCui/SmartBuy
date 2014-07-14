package com.smartbuy.services;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/DelphiService")
@Secured("ROLE_ADMIN")
public class DelphiServiceController {

	@RequestMapping(value="/VehicleStatus",method=RequestMethod.GET)
	//@ResponseBody
	public  VehicleStatus GetStatus()
	{
		VehicleStatus status=new VehicleStatus();
		status.setLatitude(10.1);
		status.setLongtitude(20);
		status.setSpeed(10);
		status.setRmp(10);
		return status;
	}
	
	@RequestMapping(value="/VehicleStatus",method=RequestMethod.POST)
	@ResponseBody
	public  VehicleStatus UpdateStatus(VehicleStatus status)
	{
		status.setLatitude(status.getLatitude()+3);
		return status;
	}
}
