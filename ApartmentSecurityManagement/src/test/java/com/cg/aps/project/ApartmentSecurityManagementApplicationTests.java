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

import com.cg.aps.entities.GuardSalaryEntity;
import com.cg.aps.repository.GuardSalaryDao;
import com.cg.aps.service.GuardSalaryService;



@SpringBootTest
class ApartmentSecurityManagementApplicationTests {
	@MockBean
	GuardSalaryDao dao;
	@Autowired
	GuardSalaryService service;
	
	@Test
	public void testAddGuardTraining()
	{
		
		GuardSalaryEntity obj = new GuardSalaryEntity(1, "yash", "aditya", new Timestamp(System.currentTimeMillis()) , new Timestamp(System.currentTimeMillis()),"Aravind", "101",2000,"credited",Date.valueOf(LocalDate.now()));
		
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}

	
	}
