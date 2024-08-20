package com.example.SalesCompaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SalesCompaignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesCompaignApplication.class, args);
	}

}
