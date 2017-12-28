/**
 * 
 */
package com.liquid.apw.demo.batch.writer;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;

/**
 * @author Liquid
 *
 */
public class DemoWriterFactory {

	private static DemoWriterFactory instance;

	private DemoWriterFactory() {
	}

	public static synchronized DemoWriterFactory getInstance(){
		if(null == instance){
			instance = new DemoWriterFactory();
		}
		return instance;
	}

	public <T> MyBatisBatchItemWriter<T> getItemWriter(Class<T> t, SqlSessionFactory sqlSessionFactory){
		MyBatisBatchItemWriter<T> writer = new MyBatisBatchItemWriter<>();
		writer.setSqlSessionFactory(sqlSessionFactory);
		writer.setStatementId("addPersonItem");
		return writer;
	}

}
