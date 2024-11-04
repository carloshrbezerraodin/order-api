package com.externob;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ExternoBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternoBApplication.class, args);
	}

}
