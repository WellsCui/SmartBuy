/**
 * 
 */
package com.smartbuy.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.smartbuy.models.VehicleStatus;

/**
 * @author wells
 *
 */
public class DelphiServiceImpl implements DelphiService {

	/* (non-Javadoc)
	 * @see com.smartbuy.services.DelphiService#GetStatus()
	 */	
	public VehicleStatus GetStatus() {
		VehicleStatus status=new VehicleStatus();
		status.setLatitude(10.1);
		status.setLongtitude(20);
		status.setSpeed(10);
		status.setRmp(10);
		return status;
	}

	/* (non-Javadoc)
	 * @see com.smartbuy.services.DelphiService#UpdateStatus(com.smartbuy.models.VehicleStatus)
	 */	
	public VehicleStatus UpdateStatus(VehicleStatus vehicleStatus) {
		vehicleStatus.setLatitude(vehicleStatus.getLatitude()+3);
		return vehicleStatus;
	}

}
