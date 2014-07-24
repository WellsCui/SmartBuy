package com.smartbuy.services;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.smartbuy.models.VehicleStatus;


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
	
	@RequestMapping(value="/VehicleStatus",method=RequestMethod.POST,consumes={"text/plain", "application/*"})
	//@ResponseBody
	public  VehicleStatus UpdateStatus(@RequestBody VehicleStatus status,UriComponentsBuilder builder)
	{
		status.setLatitude(status.getLatitude()+3);
		return status;
	}
	
	
}
