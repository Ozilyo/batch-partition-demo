package com.interfac.sb;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class contains the main method, it initializes and bootstraps the application.
 * @author Ali
 *
 */
@SpringBootApplication
@EnableBatchProcessing
@ImportResource("classpath:jobs.xml")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
//		String config = "classpath:jobs.xml";
//
//		ApplicationContext context = new ClassPathXmlApplicationContext(config);
	}
}
