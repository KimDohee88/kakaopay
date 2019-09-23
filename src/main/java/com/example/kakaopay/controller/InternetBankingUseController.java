package com.example.kakaopay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakaopay.model.InternetBankingUse;
import com.example.kakaopay.service.InternetBankingUseService;

@RestController
@RequestMapping("internetBankingUse")
public class InternetBankingUseController {
	@Autowired
	private InternetBankingUseService internetBankingUseService;
	
	//모든 인터넷뱅킹 서비스 이용현황 조회, GET, localhost:8080/internetBankingUse
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<InternetBankingUse>> getAllInternetBankUse() {
		List<InternetBankingUse> internetBankingUses = internetBankingUseService.findAll();		
		return new ResponseEntity<List<InternetBankingUse>>(internetBankingUses, HttpStatus.OK);
	}
	
	//모든 년도별 인터넷뱅킹 이용 현황 출력, GET, localhost:8080/internetBankingUse/TopDevice/{year}
	@GetMapping(value = "/TopDevice/{year}")
	public ResponseEntity<InternetBankingUse> getTop1DeviceByYear(@PathVariable String year) {
		InternetBankingUse internetBankingUse = internetBankingUseService.findTop1ByYearOrderByRateDesc(year);
		return new ResponseEntity<InternetBankingUse>(internetBankingUse, HttpStatus.OK);
	}
	
	//특정 디바이스의 인터넷 뱅킹에 접속 비율이 가장 많은 년도 출력  , GET, localhost:8080/internetBankingUse//TopUseRate/{id}
	@GetMapping(value = "/TopUseRate/{id}")
	public ResponseEntity<InternetBankingUse> getTopUseRatebyDevice(@PathVariable int id) {
		InternetBankingUse internetBankingUse = internetBankingUseService.findTop1ByDeviceidOrderByRateDesc(id);
		return new ResponseEntity<InternetBankingUse>(internetBankingUse, HttpStatus.OK);
	}
	//년도별 인터넷뱅킹을 가장 많이 이용하는 접속 기기 출력  , GET, localhost:8080/internetBankingUse//TopUseDevicesEachYear
	@GetMapping(value = "/TopUseDevicesEachYear")
	public ResponseEntity<List<InternetBankingUse>> findTopDevicesByYear() {
		List<InternetBankingUse> internetBankingUses = internetBankingUseService.findTopDevicesByYear();
		return new ResponseEntity<List<InternetBankingUse>>(internetBankingUses, HttpStatus.OK);
	}
}
