package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.repository.FlatDaoInt;
import com.cg.aps.service.FlatServiceInt;

@SpringBootTest

public class FlatServiceTest {
	@MockBean
	FlatDaoInt dao;
	@Autowired
	FlatServiceInt service;

	@Test
	public void testAddGuardTraining() {

		FlatEntity obj = new FlatEntity(101, "Sahitya", "1041", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "owner", "1041b", "10", "3BHK");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}
	
	@Test 
	public void testUpdateGuardTraining()
	{
		
		FlatEntity obj = new FlatEntity(101, "Sahitya", "1041", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "owner", "1041b", "10", "3BHK");
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    assertEquals(obj,service.add(obj));
	    
	    obj.setFloorNo("10");
	    obj.setFlatNo("1041b");
	     
	      assertEquals(obj,service.update(obj));
	
}
}
