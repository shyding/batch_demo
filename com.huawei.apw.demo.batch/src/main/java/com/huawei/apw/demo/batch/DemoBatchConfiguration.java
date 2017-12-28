package com.huawei.apw.demo.batch;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.TaskletStepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huawei.apw.demo.batch.beans.Person;
import com.huawei.apw.demo.batch.listener.DemoJobCompletionNotificationListener;
import com.huawei.apw.demo.batch.processor.PersonItemReverseProcessor;
import com.huawei.apw.demo.batch.processor.PersonItemSuffixProcessor;
import com.huawei.apw.demo.batch.reader.DemoReaderFactory;
import com.huawei.apw.demo.batch.writer.DemoWriterFactory;

//@Configuration
//@EnableBatchProcessing
//@RestController  
//@RequestMapping("/demo1")
public class DemoBatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public SqlSessionFactory sqlSessionFactory;

	@Autowired
	public DataSource dataSource;
	

	// tag::readerwriterprocessor[]

	@Bean
	public MyBatisPagingItemReader<Person> mybatisReader() {
		DemoReaderFactory factory = DemoReaderFactory.getInstance();
		return factory.getPagingAllReader(Person.class, sqlSessionFactory);
	}

	@Bean
	public PersonItemReverseProcessor processor() {
		return new PersonItemReverseProcessor();
	}

	@Bean
	public MyBatisBatchItemWriter<Person> mybatisWriter() {
		DemoWriterFactory factory = DemoWriterFactory.getInstance();
		return factory.getItemWriter(Person.class, sqlSessionFactory);
	}

	// end::readerwriterprocessor[]


	// tag::jobstep[] - extend
	@Bean
	public Job suffixUserJob(DemoJobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("suffixUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(suffixStep1())
				.end()
				.build();
	}
	
	@Bean
	public Step suffixStep1() {
		return stepBuilderFactory.get("suffixStep1")
				.allowStartIfComplete(true) // 可以重启
				.<Person, Person>chunk(100)
				.reader(mybatisReader())
				.processor(new PersonItemSuffixProcessor())
				.writer(mybatisWriter())
				.build();
	}
	// end::jobstep[] - extend

}
