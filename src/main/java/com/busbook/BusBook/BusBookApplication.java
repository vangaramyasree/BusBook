package com.busbook.BusBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BusBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusBookApplication.class, args);
	}

}
