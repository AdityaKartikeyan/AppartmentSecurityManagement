package com.cg.aps.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.repository.GuardTrainingDao;
import com.cg.aps.service.GuardTrainingService;



@SpringBootTest
class ApartmentSecurityManagementApplicationTests {

	@MockBean
	GuardTrainingDao dao;
	@Autowired
	GuardTrainingService service;
	
	@Test
	public void testAddGuardTraining()
	{
		
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),1,"HARSH","981899","accepted","10.30",Date.valueOf(LocalDate.now()));
	    
	     
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}
	
	
}
