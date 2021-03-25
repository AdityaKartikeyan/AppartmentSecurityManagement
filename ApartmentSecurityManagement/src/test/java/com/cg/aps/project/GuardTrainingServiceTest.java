package com.cg.aps.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.repository.GuardTrainingDao;
import com.cg.aps.service.GuardTrainingService;

//testing

@SpringBootTest
class GuardTrainingServiceTest {

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
	//testing update guard training entity
	
	@Test 
	public void testUpdateGuardTraining()
	{
		
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),1,"HARSH","981899","accepted","10.30",Date.valueOf(LocalDate.now()));
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    assertEquals(obj,service.add(obj));
	    
	    obj.setName("harsh");
	    obj.setStatus("working");
	     
	      assertEquals(obj,service.update(obj));
	    
	     
		
	}
	//testing delete guard training entity
	@Test
	public void testDeleteGuardTraining()
	{
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),1,"HARSH","981899","accepted","10.30",Date.valueOf(LocalDate.now()));
	    service.delete(obj);
	    verify(dao,times(1)).delete(obj);
	}

	//testing find by name guard training entity
	@Test
	public void testFindByName()
	{
		String name="aditya";
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),1,"aditya","981899","accepted","10.30",Date.valueOf(LocalDate.now()));
		GuardTrainingEntity obj1 = new GuardTrainingEntity(1225, "harsh","hello" ,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),1,"aditya","981899","good","10.30",Date.valueOf(LocalDate.now()));
		
	List<GuardTrainingEntity> list  = new ArrayList();
	list.add(obj);
	list.add(obj1);
	
		Mockito.when(dao.findByName(name)).thenReturn(list);
		assertEquals(2,service.findByName(name).size());
		
	}
	
}
