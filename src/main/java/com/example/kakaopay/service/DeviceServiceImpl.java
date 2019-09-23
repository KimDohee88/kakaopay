package com.example.kakaopay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kakaopay.exception.ResourceNotFoundException;
import com.example.kakaopay.model.Device;
import com.example.kakaopay.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceRepository deviceRepository;

	@Override
	public List<Device> findAll() {
		// TODO Auto-generated method stub
		List<Device> devices = new ArrayList<>();
		deviceRepository.findAll().forEach(e -> devices.add(e));
		return devices;
	}

	@Override
	public Device findById(int device_id) {
		// TODO Auto-generated method stub
		Device device = deviceRepository.findById(device_id).orElseThrow(() -> new ResourceNotFoundException("Device", "device_id", device_id));
		return device;
	}
	
	@Override
	public Device findByDevicename(String device_name) {
		// TODO Auto-generated method stub
		Device device = deviceRepository.findByDevicename(device_name);
		
		if(device == null) {
			return null;
		}
		else
			return device;
	}
	
	@Override
	public Device save(Device device) {
		deviceRepository.save(device);
		return device;
	}
	
	
}
