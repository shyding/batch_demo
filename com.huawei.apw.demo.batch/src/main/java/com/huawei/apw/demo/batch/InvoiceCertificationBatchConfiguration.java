/**
 * 
 */
package com.huawei.apw.demo.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.ItemListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.huawei.apw.demo.batch.beans.InvoiceCertification;
import com.huawei.apw.demo.batch.beans.SupplierInvoice;
import com.huawei.apw.demo.batch.listener.InvoiceCertificationChunkCompletionNotificationListener;
import com.huawei.apw.demo.batch.listener.InvoiceCertificationItemWriterListener;
import com.huawei.apw.demo.batch.listener.InvoiceCertificationJobCompletionNotificationListener;
import com.huawei.apw.demo.domain.InvoiceCertificationDomainService;

/**
 * @author Liquid
 *
 */
@Configuration
//@ImportResource("classpath:batch/ThreadPoolTaskExecutor.xml")
public class InvoiceCertificationBatchConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(InvoiceCertificationBatchConfiguration.class);
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
    private BasicBatchConfiguration basicBatchConfiguration;

	@Autowired
	private InvoiceCertificationJobCompletionNotificationListener jobListener;
	
	@Autowired
	private InvoiceCertificationChunkCompletionNotificationListener chunkListener;
	
	@Autowired
	private InvoiceCertificationItemWriterListener itemListener;
	
	
	public Job invoiceCertificationJob(){
		return jobBuilderFactory.get("invoiceCertificationJob")
			.incrementer(new RunIdIncrementer())
			.listener(jobListener)
			.flow(invoiceCertificationStep())
			.end()
			.build();
	}

	public Step invoiceCertificationStep() {
		return stepBuilderFactory.get("invoiceCertificationStep")
				.allowStartIfComplete(true) // 可以重启
				.<SupplierInvoice, InvoiceCertification>chunk(100)
				.reader(makeReader())
				.processor(compositeItemProcessor())
				.writer(makeWriter())
				.listener(itemListener)
				.taskExecutor(basicBatchConfiguration.threadPoolTaskExecutor()) // 并行
				.listener(chunkListener)
				.build();
	}
	
	@Bean
	public MyBatisPagingItemReader<SupplierInvoice> makeReader(){
		MyBatisPagingItemReader<SupplierInvoice> reader = new MyBatisPagingItemReader<SupplierInvoice>();
    	reader.setSqlSessionFactory(sqlSessionFactory);
    	reader.setPageSize(2000);
    	reader.setCurrentItemCount(0);
    	reader.setName("supplierInvoiceReader");
    	reader.setQueryId("com.huawei.apw.demo.batch.orm.dao.SupplierInvoiceMapper.selectByCondition");
//    	Map<String, Object> parameterValues;
//    	parameterValues = new HashMap<String, Object>();
//    	parameterValues.put("firstName", "LIQUID");
//    	reader.setParameterValues(parameterValues);
        return reader;
	}
	
	private ItemProcessor<SupplierInvoice, InvoiceCertification> makeProcessor(){
		ItemProcessor<SupplierInvoice, InvoiceCertification> processor = new ItemProcessor<SupplierInvoice, InvoiceCertification>() {
			
			@Override
			public InvoiceCertification process(SupplierInvoice item) throws Exception {
				return InvoiceCertificationDomainService.InvoiceBeanFactory.build(item);
			}
		};
		return processor;
	}
	
	@Bean
	public CompositeItemProcessor<SupplierInvoice, InvoiceCertification> compositeItemProcessor(){
		CompositeItemProcessor<SupplierInvoice, InvoiceCertification> compositeProcessor = new CompositeItemProcessor<SupplierInvoice, InvoiceCertification>();
		List<ItemProcessor<?,?>> itemProcessors = new ArrayList<ItemProcessor<?,?>>();
		itemProcessors.add(new ItemProcessor<SupplierInvoice, InvoiceCertification>() {
			
			@Override
			public InvoiceCertification process(SupplierInvoice item) throws Exception {
				return InvoiceCertificationDomainService.InvoiceBeanFactory.build(item);
			}
		});
		itemProcessors.add(new ItemProcessor<InvoiceCertification, InvoiceCertification>() {
			
			@Override
			public InvoiceCertification process(InvoiceCertification item) throws Exception {
				return item;
			}
		});
		compositeProcessor.setDelegates(itemProcessors);
		return compositeProcessor;
	}
	
	@Bean
	public MyBatisBatchItemWriter<InvoiceCertification> makeWriter(){
		MyBatisBatchItemWriter<InvoiceCertification> writer = new MyBatisBatchItemWriter<InvoiceCertification>();
		writer.setSqlSessionFactory(sqlSessionFactory);
		writer.setStatementId("com.huawei.apw.demo.batch.orm.dao.InvoiceCertificationMapper.insert");
		return writer;
	}
}
