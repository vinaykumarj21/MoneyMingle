package com.project.MoneyMingle;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MoneyMingleApplication {
//public class MoneyMingleApplication implements CommandLineRunner {
	@Bean
	public ModelMapper modelMapper(){//bean initialization
		return new ModelMapper();
	}
	//@Autowired
	//private initService initService;

	public static void main(String[] args) {
		SpringApplication.run(MoneyMingleApplication.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner from CommandLine");

		initService.init();
	}*/
}
//http://localhost:8080/settleUp/1 -> Request from postman