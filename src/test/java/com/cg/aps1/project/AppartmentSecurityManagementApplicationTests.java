package com.cg.aps1.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.repository.VisitorDao;
import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.service.VisitorService;

@SpringBootTest
class AppartmentSecurityManagementApplicationTests {
	
	@MockBean
	VisitorDao dao;
	
	@Autowired
	VisitorService service;

	@Test
	public void testAddVisitor()
	{
		
		VisitorEntity obj = new VisitorEntity(1111, "ambarish", "aditya", new Timestamp(System.currentTimeMillis()), 
		new Timestamp(System.currentTimeMillis()), "Anshul", "Anant", "101", Date.valueOf(LocalDate.now()), "11:30", "1:00");
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
	}
}
