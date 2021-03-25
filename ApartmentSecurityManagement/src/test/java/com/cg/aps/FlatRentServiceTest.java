package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.repository.FlatRentDaoInt;
import com.cg.aps.service.FlatRentServiceInt;

@SpringBootTest
public class FlatRentServiceTest {
	@MockBean
	FlatRentDaoInt dao;
	@Autowired
	FlatRentServiceInt service;

	@Test
	public void testAddGuardTraining() {

		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "Owner", "1041b", "5200", "3BHK");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}
	
	@Test 
	public void testUpdateGuardTraining()
	{
		
		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "Owner", "1041b", "5200", "3BHK");
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    assertEquals(obj,service.add(obj));
	    
	    obj.setAmount("5002");
	    obj.setFlatNo("1041b");
	     
	      assertEquals(obj,service.update(obj));
}
	
	@Test
	public void testDeleteGuardTraining()
	{
		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "Owner", "1041b", "5200", "3BHK");
	    service.delete(obj);
	    verify(dao,times(1)).delete(obj);
	}
}
