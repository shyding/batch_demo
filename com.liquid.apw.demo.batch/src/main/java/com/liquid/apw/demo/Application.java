package com.liquid.apw.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@Configuration
//@ComponentScan(basePackages = "com.liquid.apw.demo")  
@EnableAutoConfiguration
@PropertySources({ @PropertySource("classpath:db/druid.properties"), @PropertySource("classpath:app/app.properties") })
public class Application implements WebApplicationInitializer{
	

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
//        servletContext.addListener(WebAppRootListener.class);
//        servletContext.setInitParameter("contextConfigLocation",//这里是注入参数的名称
//        "classpath*:/org/springframework/batch/admin/web/resources/webapp-config.xml");
    }
}
