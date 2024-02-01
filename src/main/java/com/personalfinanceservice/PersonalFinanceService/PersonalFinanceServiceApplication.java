package com.personalfinanceservice.PersonalFinanceService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.personalfinanceservice.*"})
public class PersonalFinanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceServiceApplication.class, args);
		//var context = new AnnotationConfigApplicationContext(PersonalFinanceServiceApplication.class);
		
	
				}

}
