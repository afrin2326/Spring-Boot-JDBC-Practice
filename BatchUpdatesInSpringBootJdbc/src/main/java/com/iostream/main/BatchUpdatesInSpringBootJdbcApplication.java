package com.iostream.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.iostream.main.dao.InsertDemo;

@SpringBootApplication
public class BatchUpdatesInSpringBootJdbcApplication {

	public static void main(String[] args) 
	{
		ApplicationContext context= SpringApplication.run(BatchUpdatesInSpringBootJdbcApplication.class, args);
		
		InsertDemo insertDemo=context.getBean(InsertDemo.class);
		
		insertDemo.insertOperation();
	}

}
