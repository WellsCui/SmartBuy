package com.smartbuy.services;

import com.smartbuy.models.VehicleStatus;

public interface DelphiService {
	public  VehicleStatus GetStatus();		
	public  VehicleStatus UpdateStatus(VehicleStatus vehicleStatus);

}
