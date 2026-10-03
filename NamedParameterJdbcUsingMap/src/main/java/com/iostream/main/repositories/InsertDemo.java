package com.iostream.main.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InsertDemo 
{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void insertOperation()
	{
		Map<String,Object> map=new HashMap<>();
		map.put("key_itemid", "101");
		map.put("key_itemname", "Jeans");
		map.put("key_itemprice", "1000");
		
		String sql_query="Insert into items VALUES(:key_itemid,:key_itemname,:key_itemprice)";
	 
		
		int count=namedParameterJdbcTemplate.update(sql_query, map);
		
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
