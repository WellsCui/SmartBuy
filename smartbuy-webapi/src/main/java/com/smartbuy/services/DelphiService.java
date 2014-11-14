package com.smartbuy.services;

import com.smartbuy.domain.*;

public interface DelphiService {
	public  VehicleStatus GetStatus();		
	public  VehicleStatus UpdateStatus(VehicleStatus vehicleStatus);

}
