package com.project.Splitwise;

import com.project.Splitwise.Service.initService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	@Bean
	public ModelMapper modelMapper(){//bean initialization
		return new ModelMapper();
	}
	@Autowired
	private initService initService;

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner from CommandLine");

		initService.init();
	}
}
//http://localhost:8080/settleUp/1 -> Request from postman