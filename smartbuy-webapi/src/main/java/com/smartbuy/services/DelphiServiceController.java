package com.smartbuy.services;

import javax.ws.rs.Consumes;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
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
	
	@RequestMapping(value="/VehicleStatus",method=RequestMethod.POST
		//	,consumes={"text/plain", "application/*"}
	)
	//@ResponseBody
	public  VehicleStatus UpdateStatus(@RequestBody VehicleStatus vehicleStatus)
	//public  VehicleStatus UpdateStatus(@RequestBody String status) throws JsonParseException, JsonMappingException, IOException
	{
		/*ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		VehicleStatus vehicleStatus = mapper.readValue(status, VehicleStatus.class);*/
		vehicleStatus.setLatitude(vehicleStatus.getLatitude()+3);
		return vehicleStatus;
	}
	
	
}
