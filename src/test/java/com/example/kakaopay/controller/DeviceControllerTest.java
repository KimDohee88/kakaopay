package com.example.kakaopay.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.kakaopay.service.DeviceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DeviceControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Mock
	DeviceService deviceService;
	
	@Autowired 
	private WebApplicationContext ctx; 
	
	@InjectMocks
	private DeviceController deviceController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.webAppContextSetup(ctx)
				.build();
	}
	
	/*
	 * 모든 인터넷뱅킹 서비스 접속 기기 출력 테스트
	 ********************************************************************************************/
	@Test
	public void getAllDevices() throws Exception {
				mock.perform(
						MockMvcRequestBuilders.get("/device")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
