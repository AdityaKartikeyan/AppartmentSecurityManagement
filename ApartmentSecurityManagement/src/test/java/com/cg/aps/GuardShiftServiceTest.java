package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.repository.GuardShiftDao;
import com.cg.aps.service.GuardShiftService;
// Testing
@SpringBootTest
class GuardShiftServiceTest {
	@MockBean
	GuardShiftDao dao;
	@Autowired
	GuardShiftService service;
	
	@Test
	public void testAddGuardTraining()
	{
		
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", new Timestamp(System.currentTimeMillis()) , new Timestamp(System.currentTimeMillis()), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now()));
		
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}

	//testing update
	
	@Test 
	public void testUpdateGuardTraining()
	{
		
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", new Timestamp(System.currentTimeMillis()) , new Timestamp(System.currentTimeMillis()), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now()));
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    assertEquals(obj,service.add(obj));
	    
	    obj.setName("harsh");
	    obj.setTime("10:30");
	     
	      assertEquals(obj,service.update(obj));
	}
	@Test 
	
	public void testDeleteGuardTraining()
	{
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", new Timestamp(System.currentTimeMillis()) , new Timestamp(System.currentTimeMillis()), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now()));
		service.delete(obj);
	    verify(dao,times(1)).delete(obj);
	}

}
