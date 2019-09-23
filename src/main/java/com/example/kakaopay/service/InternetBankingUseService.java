package com.example.kakaopay.service;

import java.util.List;

import com.example.kakaopay.model.InternetBankingUse;

public interface InternetBankingUseService {
	
	InternetBankingUse save(InternetBankingUse internetBankingUse);
	
	List<InternetBankingUse> findAll();
	
	//InternetBankingUse findByYearOrderByRateDesc(String year);

	InternetBankingUse findTop1ByYearOrderByRateDesc(String year);

	InternetBankingUse findTop1ByDeviceidOrderByRateDesc(int id);
	
	List<InternetBankingUse> findTopDevicesByYear();
	
}
