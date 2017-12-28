/**
 * 
 */
package com.huawei.apw.demo.batch.reader;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

/**
 * @author Liquid
 *
 */
public class DemoReaderFactory {

	private static DemoReaderFactory instance;

	private DemoReaderFactory() {
	}

	public static synchronized DemoReaderFactory getInstance(){
		if(null == instance){
			instance = new DemoReaderFactory();
		}
		return instance;
	}

	public <T> MyBatisPagingItemReader<T> getPagingReader(Class<T> t, SqlSessionFactory sqlSessionFactory){
		MyBatisPagingItemReader<T> reader = new MyBatisPagingItemReader<T>();
    	reader.setSqlSessionFactory(sqlSessionFactory);
    	reader.setPageSize(100);
    	reader.setCurrentItemCount(0);
    	reader.setName("mybatisReader");
    	reader.setQueryId("findAllPaged");
    	Map<String, Object> parameterValues;
    	parameterValues = new HashMap<String, Object>();
    	parameterValues.put("firstName", "LIQUID");
    	reader.setParameterValues(parameterValues);
        return reader;
	}
	
	public <T> MyBatisPagingItemReader<T> getPagingAllReader(Class<T> t, SqlSessionFactory sqlSessionFactory){
		MyBatisPagingItemReader<T> reader = new MyBatisPagingItemReader<T>();
    	reader.setSqlSessionFactory(sqlSessionFactory);
    	reader.setPageSize(100);
    	reader.setCurrentItemCount(0);
    	reader.setName("mybatisReader");
    	reader.setQueryId("findAll");
        return reader;
	}

}
