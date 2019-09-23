package com.example.kakaopay.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.kakaopay.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthControllerTest {
	

    @Autowired
    private WebApplicationContext wac;
 
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
 
    private MockMvc mock;
	
    ObjectMapper om = new ObjectMapper();
    
    @Before
    public void setup() {
        this.mock = MockMvcBuilders.webAppContextSetup(this.wac)
          .addFilter(springSecurityFilterChain)
          .build();
    }
    
	@Test
    public void shouldNotAllowAccess() throws Exception {
		mock.perform(
        		MockMvcRequestBuilders.get("/api/test"))
        .andExpect(status().isUnauthorized());
    }
	
	@Test
    public void registerUser() throws Exception {

		User user = new User();
		user.setUsername("test");
		user.setPassword("12345678");
		
		String jsonRequest = om.writeValueAsString(user);
		
			  mock.perform(
				post("/api/auth/signup")
				.content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());				
    }
	
	@Test
    public void authenticateUser() throws Exception {

		User user = new User();
		user.setUsername("test");
		user.setPassword("12345678");
		
		String jsonRequest = om.writeValueAsString(user);
		
			  mock.perform(
				post("/api/auth/signin")
				.content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());				
			  
    }
}
