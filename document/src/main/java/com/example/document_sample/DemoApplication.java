package com.example.document_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		LocalImplementationsHandler bean = applicationContext.getBean(LocalImplementationsHandler.class);
		bean.printHandlers();
	}
}
