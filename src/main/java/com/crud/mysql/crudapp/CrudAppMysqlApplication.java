package com.crud.mysql.crudapp;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@EnableCaching
@SpringBootApplication
public class CrudAppMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppMysqlApplication.class, args);
		 String classpath = System.getProperty("java.class.path");
		  // String[] classPathValues = classpath.split(File.pathSeparator);
		   classpath +=";HelloWorld";
		   System.setProperty("java.class.path", classpath);
		   classpath = System.getProperty("java.class.path");
		   String[] classPathValues = classpath.split(File.pathSeparator);
		   System.out.println(Arrays.toString(classPathValues));
		
	}
	
	@Bean(name="asyncExecutor")
	Executor asynExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); 
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(15);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsyncThread-");
		executor.initialize();
		
		return executor;
	}
	
	
	
}
