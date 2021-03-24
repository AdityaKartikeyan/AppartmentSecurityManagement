package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

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
		
//		VehicleEntity obj = new VehicleEntity(1222, "Anshul","Joshi" ,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),1,"HARSH","981899","accepted","10.30",Date.valueOf(LocalDate.now()));
//	    
//	     
//		
//		
//		Mockito.when(dao.save(obj)).thenReturn(obj);
//		assertEquals(obj,service.add(obj));
			
		
	}

}
