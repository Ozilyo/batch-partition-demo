package com.interfac.sb;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * This class contains the main method, it initializes and bootstraps the application.
 * @author Ali
 *
 */
@SpringBootApplication
@EnableBatchProcessing
@ImportResource("classpath:launch-context.xml")
public class Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
