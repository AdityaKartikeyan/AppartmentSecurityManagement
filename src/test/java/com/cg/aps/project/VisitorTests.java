/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.project;

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

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.repository.VisitorDao;
import com.cg.aps.service.VisitorService;


@SpringBootTest
class VisitorTests {
	
	@MockBean
	VisitorDao dao;
	
	@Autowired
	VisitorService service;
	
	//Add Visitor
	@Test
	public void testAddVisitor()
	{
		
		VisitorEntity obj = new VisitorEntity(1111, "ambarish", "aditya", LocalDateTime.now(), 
		LocalDateTime.now(), 0, "Anshul", "Aravind", "101", Date.valueOf(LocalDate.now()), "9:30", "10:00");
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
	}
	
	//Update Visitor
	@Test 
	public void testUpdateVisitor()
	{
		
		VisitorEntity obj = new VisitorEntity(1111, "ambarish", "aditya", LocalDateTime.now(), 
		LocalDateTime.now(), 0, "Anshul", "Aravind", "101", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		Mockito.when(dao.save(obj)).thenReturn(obj);
	    assertEquals(obj,service.add(obj));
	    obj.setName("harsh");
	    assertEquals(obj,service.update(obj));
	}

	//Delete Visitor
	@Test
	public void testDeleteVisitor()
	{
		VisitorEntity obj = new VisitorEntity(1111, "ambarish", "aditya", LocalDateTime.now(), 
		LocalDateTime.now(), 0, "Anshul", "Aravind", "101", Date.valueOf(LocalDate.now()), "9:30", "10:00");
		service.delete(obj);
	    verify(dao,times(1)).delete(obj);
	}	    
	
	//Find Visitor by Name
	@Test
	public void testFindByName()
	{
		String name="Ambarish";
		VisitorEntity obj = new VisitorEntity(1111, "ambarish", "aditya", LocalDateTime.now(), 
		LocalDateTime.now(), 0, "Anshul", "Aravind", "101", Date.valueOf(LocalDate.now()), "9:30", "10:00");
		VisitorEntity obj1 = new VisitorEntity(1111, "roy", "anand", LocalDateTime.now(), 
		LocalDateTime.now(), 0, "adiya", "Aravind", "103", Date.valueOf(LocalDate.now()), "4:30", "9:00");
		 
		List<VisitorEntity> list = new ArrayList();
		list.add(obj);
		list.add(obj1);

		Mockito.when(dao.findByName(name)).thenReturn(list);
		assertEquals(2,service.findByName(name).size());
		
	}
	
	
	@Test
	public void testFindByPk()
	{
		
		Optional<VisitorEntity> obj = Optional.of(new VisitorEntity(1111,"ambarish","aditya", 
		LocalDateTime.now(),LocalDateTime.now(), 
		0, "Anshul", "Aravind", "101", Date.valueOf(LocalDate.now()), "9:30", "10:00"));
 
		Mockito.when(dao.findById(obj.get().getVisitorId())).thenReturn(obj);
		Optional<VisitorEntity> obj1 = service.findByPk(obj.get().getVisitorId());
		assertEquals(obj.get().getVisitorId(),obj1.get().getVisitorId());
		
	}
	
	//Searching in list
	@Test
	public void testSearch()
	{
		VisitorEntity obj = new VisitorEntity(1111, "ambarish", "aditya", LocalDateTime.now(), 
		LocalDateTime.now(), 0, "Anshul", "Aravind", "101", Date.valueOf(LocalDate.now()), "9:30", "10:00");
		VisitorEntity obj1 = new VisitorEntity(1111, "roy", "anand", LocalDateTime.now(), 
		LocalDateTime.now(), 0, "adiya", "Aravind", "103", Date.valueOf(LocalDate.now()), "4:30", "9:00");
		
		List<VisitorEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
	}
}
