package com.example.kakaopay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakaopay.model.Device;
import com.example.kakaopay.service.DeviceService;

@RestController
@RequestMapping("device")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	//모든 인터넷뱅킹 서비스 접속 기기 조회, GET, localhost:8080/device
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Device>> getAllDevices() {
		List<Device> devices = deviceService.findAll();
		return new ResponseEntity<List<Device>>(devices, HttpStatus.OK);
	}
}
