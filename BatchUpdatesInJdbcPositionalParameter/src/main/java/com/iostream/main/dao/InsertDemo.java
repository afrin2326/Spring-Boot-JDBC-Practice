package com.iostream.main.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iostream.main.beans.Items;

@Repository
public class InsertDemo 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertOperation()
	{

		Items item1=new Items();  
		item1.setItemid("104");
		item1.setItemname("Pant");
		item1.setItemprice("20000");
		
		

		Items item2=new Items();  
		item2.setItemid("105");
		item2.setItemname("Shirt");
		item2.setItemprice("10000");
		
		

		Items item3=new Items();  
		item3.setItemid("104");
		item3.setItemname("Pant");
		item3.setItemprice("20000");
		
		
		List<Items> item_list=new ArrayList<>();
		item_list.add(item1);
		item_list.add(item2);
		item_list.add(item3);
		
		
		String sql_query="insert into items values(?,?,?)";
		
		jdbcTemplate.batchUpdate(sql_query, new BatchPreparedStatementSetter() 
		{
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				Items item=item_list.get(i);
				ps.setString(1, item.getItemid());
				ps.setString(2, item.getItemid());
				ps.setString(3, item.getItemid());
				
			}
			
			@Override
			public int getBatchSize()
			{
				
				return item_list.size();
			}
		});
		
				
		
		
		
		
		
		
	}

}
