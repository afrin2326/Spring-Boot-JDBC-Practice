package com.iostream.main.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iostream.main.beans.Items;

@Repository
public class InsertDemo 
{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void insertOperation()
	{
		Items item=new Items();  
		item.setItemid("104");
		item.setItemname("Pant");
		item.setItemprice("20000");
		
		BeanPropertySqlParameterSource param=new BeanPropertySqlParameterSource(item);
		
		String sql_query="Insert into items VALUES(:itemid,:itemname,:itemprice)";
	 
		
		int count=namedParameterJdbcTemplate.update(sql_query, param);
		
		if(count>0)
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Success");
		}
	}
}
