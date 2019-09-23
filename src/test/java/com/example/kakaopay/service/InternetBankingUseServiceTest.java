package com.example.kakaopay.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.kakaopay.model.InternetBankingUse;
import com.example.kakaopay.repository.InternetBankingUseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InternetBankingUseServiceTest {

	
	@Autowired
	InternetBankingUseService internetBankingUseService;
	
	@Autowired
	InternetBankingUseRepository internetBankingUseRepository;
	
	@InjectMocks
	private InternetBankingUse internetBankingUse;
	
	@Autowired
	private MockMvc mock;
	
	@Autowired 
	private WebApplicationContext ctx; 
	
	@Autowired
    private FilterChainProxy springSecurityFilterChain;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.webAppContextSetup(ctx)
				.addFilter(springSecurityFilterChain)
				.build();
	}

	/*
	 * 인터넷뱅킹 접속 기기 저장 Service 테스트
	 ********************************************************************************************/
	@Test(expected = AuthenticationException.class)
	public void saveIbk() throws AuthenticationException {
		
		InternetBankingUse ibk = new InternetBankingUse("2011",2,"데스크탑 컴퓨터","95.1","52.9");
		
		InternetBankingUse found = internetBankingUseRepository.findTop1ByYearOrderByRateDesc("2011");
	
		System.out.println("result>>>>>>>>>.............."+found);

		assertThat(found.equals(ibk));
	}
}
