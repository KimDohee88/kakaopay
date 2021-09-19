
작성일자: 2019.09.23

Program Language : Java

Framework : String Boot(Rest Api, JPA 기반)

Database : mysql

Test Tool : Junit


# 구현 기능
1. 모든 인터넷뱅킹 서비스 접속 기기 조회, GET, localhost:8080/device
2. 모든 인터넷뱅킹 서비스 이용현황 조회, GET, localhost:8080/internetBankingUse
3. 모든 년도별 인터넷뱅킹 이용 현황 출력, GET, localhost:8080/internetBankingUse/TopDevice/{year}
4. 특정 디바이스의 인터넷 뱅킹에 접속 비율이 가장 많은 년도 출력  , GET, localhost:8080/internetBankingUse//TopUseRate/{id}
5. 년도별 인터넷뱅킹을 가장 많이 이용하는 접속 기기 출력  , GET, localhost:8080/internetBankingUse//TopUseDevicesEachYear
6. 로그인, POST, localhost:8080/api/auth/signin
7. 회원가입, POST, localhost:8080/api/auth/signup
8. JWT를 이용한 패스워드 인코딩 및 특정 서명하여 생성, 로그인 시 토큰 발급.

# 테이블 구성
1. Device(Device_id,Device_name)
2. InternetBankingUse(Year, Device_id,Device_name, Rate, Total_Rate)
2. User(Username, Password)
