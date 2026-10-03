package com.iostream.main.dbcon;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DbConnection 
{
	@Autowired
	private DataSource dataSource;
	
	public void checkConnection() 
	{
		try(
				Connection con1=dataSource.getConnection();
				Connection con2=dataSource.getConnection();
				Connection con3=dataSource.getConnection();
				
				)
		{
			System.err.println("success ");
			
		}
		catch(Exception e)
		{
			System.err.println("fail : "+e.getMessage());
		}
		
		
	}

}
