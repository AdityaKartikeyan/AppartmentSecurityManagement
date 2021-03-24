package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.repository.GuardShiftDao;
import com.cg.aps.service.GuardShiftService;

@SpringBootTest
class ApartmentSecurityManagementApplicationTests {
	@MockBean
	GuardShiftDao dao;
	@Autowired
	GuardShiftService service;
	
	@Test
	public void testAddGuardTraining()
	{
		
		GuardShiftEntity obj = new GuardShiftEntity(0, null, null, null, null, 0, null, null, null);
		obj.setName("aditya");
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}

	
	}


