package com.example.kakaopay.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

import com.example.kakaopay.service.InternetBankingUseService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InternetBankingUseControllerTest {
	@Autowired
	private MockMvc mock;
	
	@Mock
	InternetBankingUseService internetBankingUseService;
	
	@Autowired 
	private WebApplicationContext ctx; 
	
	@InjectMocks
	private InternetBankingUseController internetBankingUseController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.webAppContextSetup(ctx)
				.build();
	}
	
	/*
	 * 모든 년도별 인터넷뱅킹 이용 현황 출력
	 ********************************************************************************************/
	@Test
	public void getAllInternetBankUse() throws Exception {
				mock.perform(
						MockMvcRequestBuilders.get("/internetBankingUse")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	/*
	 * 년도별 인터넷뱅킹을 가장 많이 이용하는 접속 기기 출력
	 ********************************************************************************************/
	@Test
	public void findTopDevicesByYear() throws Exception {
				mock.perform(
						MockMvcRequestBuilders.get("/internetBankingUse/TopUseDevicesEachYear")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	/*
	 * 특정 년도의 인터넷뱅킹을 가장 많이 접속한 기기 출력          INPUT:Year(2011)
	 ********************************************************************************************/
	@Test
	public void getTop1DeviceByYear() throws Exception {
				mock.perform(
						MockMvcRequestBuilders.get("/internetBankingUse/TopDevice/{year}", "2011")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("year").value("2011"))
				.andExpect(jsonPath("devicename").value("데스크탑 컴퓨터"))
				.andExpect(jsonPath("rate").value("95.1"))
				.andDo(print());
	}
	
	@Test
	public void getTop1DeviceByYear_NotExist() throws Exception {
				mock.perform(
						MockMvcRequestBuilders.get("/internetBankingUse/TopDevice/{year}", "2010")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("year").doesNotExist());
	}
	
	/*
	 * 특정 디바이스의 인터넷 뱅킹에 접속 비율이 가장 많은 년도 출력         INPUT:Device_ID(1)
	 ********************************************************************************************/
	@Test
	public void getTopUseRatebyDevice() throws Exception {
				mock.perform(
						MockMvcRequestBuilders.get("/internetBankingUse/TopUseRate/{id}", "1")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("year").value("2017"))
				.andExpect(jsonPath("devicename").value("스마트폰"))
				.andExpect(jsonPath("rate").value("90.6"))
				.andDo(print());
	}
	
	@Test
	public void getTopUseRatebyDevice_NotExist() throws Exception {
				mock.perform(
						MockMvcRequestBuilders.get("/internetBankingUse/TopUseRate/{id}", "100")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("year").doesNotExist())
				.andDo(print());
	}

}
