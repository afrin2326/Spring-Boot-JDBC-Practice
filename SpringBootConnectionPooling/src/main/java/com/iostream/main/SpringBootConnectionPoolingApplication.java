package com.iostream.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.iostream.main.dbcon.DbConnection;

@SpringBootApplication
public class SpringBootConnectionPoolingApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SpringBootConnectionPoolingApplication.class, args);
		
		DbConnection dbConnection=context.getBean(DbConnection.class);
		
		dbConnection.checkConnection();
	}

}
