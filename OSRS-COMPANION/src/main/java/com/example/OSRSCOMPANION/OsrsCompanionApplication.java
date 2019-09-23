package com.example.OSRSCOMPANION;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class OsrsCompanionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsrsCompanionApplication.class, args);
	}

}
