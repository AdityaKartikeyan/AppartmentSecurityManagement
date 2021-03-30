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
import org.springframework.dao.DataAccessException;

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
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
	public void testAddVisitor() throws DuplicateRecordException
	{
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(obj,service.add(obj));
			}
			catch(DuplicateRecordException e)
			{
				e.printStackTrace();
			}
	}
	
	@Test
	public void testAddVisitorWrong() throws DuplicateRecordException
	{
		String name = "1234";
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(name,service.add(obj));
			}
			catch(DuplicateRecordException e)
			{
				e.printStackTrace();
			}
		}
	
	
	@Test
	public void testAddVisitorExisiting() throws DuplicateRecordException
	{
		String visitorId = "1";
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(visitorId,service.add(obj).getVisitorId());
			}
			catch(DuplicateRecordException e)
			{
				e.printStackTrace();
			}
	}
	
	//Update Visitor
	@Test 
	public void testVisitorEntity() throws RecordNotFoundException
	{
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {

			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Test 
	public void testVisitorEntityWrong() throws RecordNotFoundException
	{
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
		VisitorEntity obj1 = new VisitorEntity("2", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(obj1, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Delete Visitor
	@Test
	public void testDeleteVisitor() throws RecordNotFoundException
	{
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
		Optional<VisitorEntity> obj1 = Optional.of(new VisitorEntity(1,"2", "ambarish", null, null, "aditya", "Anshul", null, null, Date.valueOf(LocalDate.now()), "11:30", "1:00"));
		
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
			 VisitorEntity src= service.delete(obj1.get().getId());
			 assertEquals(1,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
	}	    
	
	//Find Visitor by Name
	@Test
	public void testFindByName() throws RecordNotFoundException
	{
		Optional<VisitorEntity> obj = Optional.of(new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "9:30", "10:00"));
		 
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		Optional<VisitorEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(obj.get().getName(),obj1.get().getName());
	}
	@Test
	public void testFindByNameWrong() throws RecordNotFoundException
	{
		String name="Raju";
		Optional<VisitorEntity> obj = Optional.of(new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "9:30", "10:00"));
		try
		{
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		
		Optional<VisitorEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(name,obj1.get().getName());
		}
		catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//find by Pk
	@Test
	public void testFindByPk() throws RecordNotFoundException
	{
		Optional<VisitorEntity> obj = Optional.of(new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "9:30", "10:00"));
		
		Mockito.when(dao.findByVisitorId(obj.get().getVisitorId())).thenReturn(obj);
		Optional<VisitorEntity> obj1 = Optional.of(service.findByPk(obj.get().getVisitorId()));
		assertEquals(obj.get().getVisitorId(),obj1.get().getVisitorId());
	}
	@Test
	public void testFindByPkWrong() throws RecordNotFoundException
	{
		long userId=123;
		Optional<VisitorEntity> obj = Optional.of(new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "9:30", "10:00"));
		
		try{
			Mockito.when(dao.findByVisitorId(obj.get().getVisitorId())).thenReturn(obj);
		Optional<VisitorEntity> obj1 = Optional.of(service.findByPk(obj.get().getVisitorId()));
		assertEquals(userId,obj1.get().getVisitorId());
		}
		catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Searching in list
	@Test
	public void testSearch() throws DatabaseException
	{
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
		VisitorEntity obj1 = new VisitorEntity("2", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		List<VisitorEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		try {
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
		}
		catch(DatabaseException e)
		{ e.printStackTrace();
		}
	}
	@Test
	public void testSearchWrong() throws DatabaseException
	{
		VisitorEntity obj = new VisitorEntity("1", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
		VisitorEntity obj1 = new VisitorEntity("2", "ambarish", "aditya", "Anshul", Date.valueOf(LocalDate.now()), "11:30", "1:00");
	    
		List<VisitorEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		try {
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(3,service.search().size());
		}
		catch(DatabaseException e)
		{ e.printStackTrace();
		}
	}
}
