package com.example.kakaopay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kakaopay.model.InternetBankingUse;
import com.example.kakaopay.repository.InternetBankingUseRepository;

@Service
public class InternetBankingUseServiceImpl implements InternetBankingUseService {

	@Autowired
	private InternetBankingUseRepository internetBankingUseRepository;
	
	@Override
	public InternetBankingUse save(InternetBankingUse internetBankingUse) {
		internetBankingUseRepository.save(internetBankingUse);
		return internetBankingUse;
	}

	@Override
	public List<InternetBankingUse> findAll() {
		// TODO Auto-generated method stub
		List<InternetBankingUse> internetBankingUses = new ArrayList<>();
		internetBankingUseRepository.findAll().forEach(e -> internetBankingUses.add(e));
		return internetBankingUses;
	}
	
	@Override 
	public InternetBankingUse findTop1ByYearOrderByRateDesc(String year) {
		// TODO Auto-generated method stub 
		InternetBankingUse internetBankingUse = internetBankingUseRepository.findTop1ByYearOrderByRateDesc(year); 
		return internetBankingUse; 
	}
	
	@Override 
	public InternetBankingUse findTop1ByDeviceidOrderByRateDesc(int id) {
		// TODO Auto-generated method stub 
		InternetBankingUse internetBankingUse = internetBankingUseRepository.findTop1ByDeviceidOrderByRateDesc(id); 
		return internetBankingUse; 
	}
	
	@Override
	public List<InternetBankingUse> findTopDevicesByYear() {
		// TODO Auto-generated method stub
		List<InternetBankingUse> internetBankingUses = new ArrayList<>();
		internetBankingUses.addAll(internetBankingUseRepository.findTopDevicesByYear());
		return internetBankingUses;
	}
	
}
