package com.iostream.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InsertDemo 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertOperation()
	{
		//-----------------------------way 1-------------------
		/*
		String sql_query1="insert into items values('101','pant','890')";
		String sql_query2="insert into items values('102','shirt','700')";
		String sql_query3="insert into items values('103','panjabi','600')";
				
		int[] count=jdbcTemplate.batchUpdate(sql_query1,sql_query2,sql_query3);
		
		for(int i:count)
		{
			System.out.println("success :" +i);
		}
		
		*/
		
		String sql_query1="insert into items values('101','pant','890')";
		String sql_query2="insert into items values('102','shirt','700')";
		String sql_query3="insert into items values('103','panjabi','600')";
		
		String[] sql_query= {sql_query1,sql_query2,sql_query3};
		
				
		int[] count=jdbcTemplate.batchUpdate(sql_query);
		
		for(int i:count)
		{
			System.out.println("success :" +i);
		}
		
		
		
	}

}
