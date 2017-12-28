package com.huawei.apw.demo.batch;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.huawei.apw.demo.batch.beans.Person;
import com.huawei.apw.demo.batch.listener.JobCompletionNotificationListener;
import com.huawei.apw.demo.batch.processor.PersonItemReverseProcessor;
import com.huawei.apw.demo.batch.reader.DemoReaderFactory;

//@Configuration
//@EnableBatchProcessing
//@Import({ SimpleBatchConfiguration.class })
public class BatchConfiguration {

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
	public JdbcBatchItemWriter<Person> rawJdbcWriter() {
		JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<Person>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
		writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
		writer.setDataSource(dataSource);
		return writer;
	}
	// end::readerwriterprocessor[]

	// tag::jobstep[]
	@Bean
	public Job reverseUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("reverseUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(reverseStep1())
				.end()
				.build();
	}

	@Bean
	public Step reverseStep1() {
		return stepBuilderFactory.get("reverseStep1")
				.allowStartIfComplete(true) // 可以重启
				.<Person, Person>chunk(100)
				.reader(mybatisReader())
				.processor(new PersonItemReverseProcessor())
				.writer(rawJdbcWriter())
				.build();
	}
	// end::jobstep[]


}
