package com.liquid.apw.demo.batch.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liquid.apw.demo.batch.beans.InvoiceCertification;
import com.liquid.apw.demo.batch.orm.dao.InvoiceCertificationMapper;

@Component
public class InvoiceCertificationJobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(InvoiceCertificationJobCompletionNotificationListener.class);

	@Autowired
	public InvoiceCertificationJobCompletionNotificationListener() {
	}
	
	@Autowired
	private InvoiceCertificationMapper mapper;
	
	private long startMillisTime;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		startMillisTime = System.currentTimeMillis();
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		long intervalTime = System.currentTimeMillis() - startMillisTime;
		log.info("Liquid : Job last time is " + intervalTime + " milliseconds");
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

//			List<InvoiceCertification> results = mapper.selectByCondition(new InvoiceCertification());
//
//			for (InvoiceCertification certification : results) {
//				log.info("Found <" + certification + "> in the database.");
//			}

		}
	}
}
