package com.example.kakaopay;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.kakaopay.model.Device;
import com.example.kakaopay.model.InternetBankingUse;
import com.example.kakaopay.repository.DeviceRepository;
import com.example.kakaopay.repository.InternetBankingUseRepository;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class KakaopayApplication implements CommandLineRunner {
 
	public static void main(String[] args) {
		SpringApplication.run(KakaopayApplication.class, args);
	}
	
	@Autowired
	DeviceRepository deviceRepository;
	
	@Autowired
	InternetBankingUseRepository internetBankingUseRepository;
	
	@Override
	public void run(String... args) throws Exception {
			
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(Paths.get("./data/2019년하반기_서버개발자_데이터.csv"));	
			String header = "";    //scv파일 헤더부
			String data = "";      //scv파일 데이터부
   
			 
			header = br.readLine();
			String headerArray[] = header.split(",");
			int[] headerId = new int[headerArray.length];
			
			//헤더부 분리 및 Device테이블 데이터 삽입
			for(int i = 2; i < headerArray.length ; i++) {
					deviceRepository.save(new Device(i, headerArray[i]));
					headerId[i] = deviceRepository.findByDevicename(headerArray[i]).getDevice_id();
			}
			
			//데이터부 분리 및 데이터 삽입
			while((data = br.readLine()) !=null) {
				String array[] = data.split(",");
				 
				for(int i = 2; i < headerArray.length ; i++) {
					internetBankingUseRepository.save(new InternetBankingUse(array[0], headerId[i], headerArray[i], array[i], array[1]));
				} 
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
