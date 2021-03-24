package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.VehicleEntity;
import com.cg.aps.repository.VehicleDao;
import com.cg.aps.service.VehicleService;

@SpringBootTest
class ApartmentSecurityManagementApplicationTests {

	@MockBean
	VehicleDao dao;
	@Autowired
	VehicleService service;
	
	@Test
	public void testAddGuardTraining()
	{
		
		VehicleEntity obj = new VehicleEntity(1222, "Anshul","Joshi" ,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"AJ","101","11:30","12:30",Date.valueOf(LocalDate.now()),"103","Honda City");
	    
	     
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}

}
