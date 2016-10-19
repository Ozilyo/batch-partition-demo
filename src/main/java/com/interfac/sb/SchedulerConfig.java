package com.interfac.sb;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {

	private static final Logger log = LoggerFactory.getLogger(SchedulerConfig.class);
	
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	public void run() {

		try {

			Date dateParam = new Date();
			JobParameters param = new JobParametersBuilder().addDate("date", dateParam).toJobParameters();

			log.info(dateParam.toString());

			JobExecution execution = jobLauncher.run(job, param);
			log.info("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
