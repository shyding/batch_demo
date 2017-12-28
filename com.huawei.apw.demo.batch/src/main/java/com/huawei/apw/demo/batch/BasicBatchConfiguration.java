/**
 * 
 */
package com.huawei.apw.demo.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Liquid
 *
 */
@Configuration
@EnableBatchProcessing
@Import({ SimpleBatchConfiguration.class })
public class BasicBatchConfiguration {
	
	@Bean
	public TaskExecutor threadPoolTaskExecutor(){
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setMaxPoolSize(20);
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setThreadNamePrefix("LiquidBatch");
		taskExecutor.setQueueCapacity(30);
		return taskExecutor;
	}

}
