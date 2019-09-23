package com.example.kakaopay.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.kakaopay.model.Device;
import com.example.kakaopay.repository.DeviceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeviceServiceTest {
	
	@Mock
	private DeviceRepository deviceRepository;
	
	@InjectMocks
	private Device device;

	
	/*
	 * 인터넷뱅킹 접속 기기 저장 Service 테스트
	 ********************************************************************************************/
	@Test
	public void save() {
		
		Device device = new Device(1,"스마트폰");
		
		when(deviceRepository.save(new Device(1,"스마트폰"))).thenReturn(device);
		
		Optional<Device> result =  deviceRepository.findById(1);
		assertThat(result.equals(device));
	}
	
	/*
	 * 인터넷뱅킹 접속 기기 출력 Service 테스트
	 ********************************************************************************************/
	@Test
	public void findAll() {
		
		Device device1 = new Device(1,"스마트폰");
		Device device2 = new Device(2,"데스트탑 컴퓨터");
		
		deviceRepository.save(device1);
		deviceRepository.save(device2);
		
		List<Device> devices = new ArrayList<>();
		devices.add(device1);
		devices.add(device2);
		
		when(deviceRepository.findAll()).thenReturn(devices);
		
		List<Device> result =  deviceRepository.findAll();
		assertThat(result.equals(devices));
		
	}

}
