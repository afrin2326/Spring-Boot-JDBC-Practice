package com.iostream.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.iostream.main.repositories.InsertDemo;

@SpringBootApplication
public class NamedParameterJdbcUsingMapApplication 
{

	public static void main(String[] args) 
	{
		ApplicationContext context=SpringApplication.run(NamedParameterJdbcUsingMapApplication.class, args);
		InsertDemo id=context.getBean(InsertDemo.class);
		id.insertOperation();
	}

}
