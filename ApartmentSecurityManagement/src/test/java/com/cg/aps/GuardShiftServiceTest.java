package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", LocalDateTime.now() , LocalDateTime.now(), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now()));
		
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}

	//testing update
	
	@Test 
	public void testUpdateGuardTraining()
	{
		
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", LocalDateTime.now() , LocalDateTime.now(), 10, "anshul", "11:30", 
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
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", LocalDateTime.now() , LocalDateTime.now(), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now()));
		service.delete(obj.getUserId());
	    verify(dao,times(1)).deleteById(obj.getUserId());
	}

	
	@Test
	public void testFindByName()
	{
		String name="Anshul";
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", LocalDateTime.now() , LocalDateTime.now(), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now()));
		GuardShiftEntity obj1 = new GuardShiftEntity(10, "anshul", "aravind", LocalDateTime.now() , LocalDateTime.now(), 100, "aditya", "12:30", 
				Date.valueOf(LocalDate.now()));
		
	List<GuardShiftEntity> list  = new ArrayList();
	list.add(obj);
	list.add(obj1);
	
		Mockito.when(dao.findByName(name)).thenReturn(list);
		assertEquals(2,service.findByName(name).size());
		
	}
	
	@Test
	public void testFindByPk()
	{
		
		Optional<GuardShiftEntity> obj =Optional.of(new GuardShiftEntity(1, "yash", "aditya", LocalDateTime.now() , LocalDateTime.now(), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now())));
 
		Mockito.when(dao.findById( obj.get().getUserId())).thenReturn(obj);
		Optional<GuardShiftEntity> obj1 = service.findByPk(obj.get().getUserId());
		assertEquals(obj.get().getUserId(),obj1.get().getUserId());
		
	}
	@Test
	public void testSearch()
	{
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", LocalDateTime.now() , LocalDateTime.now(), 10, "anshul", "11:30", 
				Date.valueOf(LocalDate.now()));
		GuardShiftEntity obj1 = new GuardShiftEntity(1, "pk", "ankit", LocalDateTime.now() , LocalDateTime.now(), 100, "aman", "12:30", 
				Date.valueOf(LocalDate.now()));
		List<GuardShiftEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
	}
}
