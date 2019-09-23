package com.example.kakaopay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestRestAPIs {
	
	//로그인 후 접속 테스트, POST, localhost:8080/api/test
	@GetMapping("test")
	public String userAccess() {
		return ">>> User Contents!";
	}

}