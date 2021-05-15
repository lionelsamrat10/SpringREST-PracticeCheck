package com.cognizant.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages =  {"com.cognizant.truyum.controller","com.cognizant.truyum.service","com.cognizant.truyum.model","com.cognizant.truyum.dao"})
public class TruyumApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Start!!");
		SpringApplication.run(TruyumApplication.class, args);
		LOGGER.info("End!!");
	}
}
