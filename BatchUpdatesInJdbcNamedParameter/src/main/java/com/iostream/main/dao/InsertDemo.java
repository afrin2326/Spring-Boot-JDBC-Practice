package com.iostream.main.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iostream.main.beans.Items;

@Repository
public class InsertDemo 
{
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;
	
	public void insertOperation()
	{
		
		Map<String,Object> map1=new HashMap<>();
		
		map1.put("key_itemid", "109");
		map1.put("key_itemname", "jjj");
		map1.put("key_itemprice", "90");
		
		Map<String,Object> map2=new HashMap<>();
		map2.put("key_itemid", "107");
		map2.put("key_itemname", "uuj");
		map2.put("key_itemprice", "40");
		
		Map<String,Object> map3=new HashMap<>();
		
		map3.put("key_itemid", "100");
		map3.put("key_itemname", "kjj");
		map3.put("key_itemprice", "60");
		
		Map[] map= {map1,map2,map3};
		
		String sql_query="insert into items values(:key_itemid,:key_itemname,:key_itemprice)";
		int[] count=namedParameterJdbcTemplate.batchUpdate(sql_query,map);
		
		for(int i:count)
		{
			System.out.println("success");
		}

			
		
	}

}
