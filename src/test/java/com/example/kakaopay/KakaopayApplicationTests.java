package com.example.kakaopay;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.kakaopay.model.Device;
import com.example.kakaopay.model.InternetBankingUse;
import com.example.kakaopay.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KakaopayApplicationTests {
	
	@Autowired
	MockMvc mock;
	
	@Autowired
	Device device;
	
	@Autowired
	InternetBankingUse internetBankingUse;
	
	@Autowired
	User user;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testRegisterUser() throws Exception {
		mock.perform(
				MockMvcRequestBuilders.post("/api/signup/")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.param("username", "test")
				.param("password", "12345678"))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void getAllDevices() throws Exception {
		mock.perform(
				get("/device"))
				.andExpect(status().isOk())
				.andDo(print());
	}


}
