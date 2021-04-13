package com.example.tradewebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TradeWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeWebServicesApplication.class, args);
	}

}
