package com.iostream.main.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InsertDemo 
{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void insertOperation()
	{
		MapSqlParameterSource param=new MapSqlParameterSource();
		//param.addValue("key_itemid", "102");
		//param.addValue("key_itemname", "T-Shirt");
		//param.addValue("key_itemprice", "1000");
		
		param.addValue("key_itemid", "103")
		     .addValue("key_itemname", "Sweater")
		     .addValue("key_itemprice", "3000");
		
		String sql_query="Insert into items VALUES(:key_itemid,:key_itemname,:key_itemprice)";
	 
		
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
