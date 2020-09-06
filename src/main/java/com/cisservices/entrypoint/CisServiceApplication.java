package com.cisservices.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cisservices")
@SpringBootApplication
//(scanBasePackages= {"com.cisservices"})
public class CisServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CisServiceApplication.class, args);
		System.out.println("Running successfully...!!!");
	}

}
