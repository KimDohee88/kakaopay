package com.example.kakaopay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.kakaopay.model.InternetBankingUse;

public interface InternetBankingUseRepository extends JpaRepository <InternetBankingUse, String> {

	
	InternetBankingUse findTop1ByYearOrderByRateDesc(String year);

	InternetBankingUse findTop1ByDeviceidOrderByRateDesc(int id);
	
	@Query(value = "SELECT * FROM (SELECT YEAR, MAX(rate) rate FROM kakaopay.internetbankinguse GROUP BY YEAR ) a, kakaopay.internetbankinguse b WHERE a.year = b.year AND a.rate = b.rate Order by b.year ",
		   nativeQuery = true)
	List<InternetBankingUse> findTopDevicesByYear();
}
