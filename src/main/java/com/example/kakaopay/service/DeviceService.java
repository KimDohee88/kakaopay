package com.example.kakaopay.service;

import java.util.List;

import com.example.kakaopay.model.Device;

public interface DeviceService {
	List<Device> findAll();
	
	Device findById(int device_id);
	
	Device findByDevicename(String device_name);
	
	Device save(Device device);
	
	
}
