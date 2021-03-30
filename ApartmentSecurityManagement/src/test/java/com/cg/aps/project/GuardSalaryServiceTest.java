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

import com.cg.aps.entities.GuardSalaryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GuardSalaryDao;
import com.cg.aps.service.GuardSalaryService;



/**
 * @author Aravind
 *
 */
@SpringBootTest
class GuardSalaryServiceTest {
	@MockBean
	GuardSalaryDao dao;
	@Autowired
	GuardSalaryService service;
	
	
	//test case for adding values 
	@Test
	public void testAddGuardSalary() throws DuplicateRecordException
	{
		
		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
		
		
		
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
	public void testAddGuardSalaryWrong() throws DuplicateRecordException
	{
		long userId1=123;
		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
		
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		
		try {
			assertEquals(userId1,service.add(obj));
			
			}
			catch(DuplicateRecordException e)
			{
				e.printStackTrace();
			}
		}
			
		

	@Test
	public void testAddGuardSalaryExistingRec() throws DuplicateRecordException
	{
		long userId1=2000;
		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
		
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		
		try {
			assertEquals(userId1,service.add(obj).getUserId());
			
			}
			catch(DuplicateRecordException e)
			{
				e.printStackTrace();
			}
		}
			
			
	//test case for updating the existing values
	@Test 
	public void testUpdateGuardSalary() throws RecordNotFoundException
	{
		
		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {

			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void testUpdateGuardSalaryWrong() throws RecordNotFoundException
	{

		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
		GuardSalaryEntity obj1 = new GuardSalaryEntity("adiya", 2000,"101","credited",Date.valueOf(LocalDate.now()));

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {

			assertEquals(obj1, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	
	//test case for deleting values 
	@Test
	public void testDeleteGuardSalary() throws RecordNotFoundException
	{
		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
		Optional<GuardSalaryEntity> obj1 = Optional.of(new GuardSalaryEntity(1,"aravind", null, null, null, null, 2000,"101","credited",Date.valueOf(LocalDate.now())));
	 
	    Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		  GuardSalaryEntity src= service.delete(obj1.get().getId());
		 
			  assertEquals(1,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
	}
	
	@Test
	public void testDeleteGuardSalaryWrong() throws RecordNotFoundException
	{
		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
		Optional<GuardSalaryEntity> obj1 = Optional.of(new GuardSalaryEntity(1,"aravind", null, null, null, null, 2000,"101","credited",Date.valueOf(LocalDate.now())));
	 
	    Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		  GuardSalaryEntity src= service.delete(obj1.get().getId());
		 
			  assertEquals(0,src.getId());
		  }
		  catch(RecordNotFoundException e)		
		     {
		    	 e.printStackTrace();
		     }
	}
	
	//test case for finding a value by it's name
	@Test
	public void testFindByName() throws RecordNotFoundException
	{
	
		
		Optional<GuardSalaryEntity> obj =Optional.of(new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now())));
		 
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		Optional<GuardSalaryEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(obj.get().getName(),obj1.get().getName());
	

	}
	
	@Test
	public void testFindByNameWrong() throws RecordNotFoundException
	{
	
		String name="Raju";
		Optional<GuardSalaryEntity> obj =Optional.of(new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now())));
		 
		try
		{
			Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		
		Optional<GuardSalaryEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(name,obj1.get().getName());
		}
		catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	//test case for finding a value by Id
	@Test
	public void testFindByPk() throws RecordNotFoundException
	{
		
		Optional<GuardSalaryEntity> obj =Optional.of(new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now())));
 
		Mockito.when(dao.findByUserId((int) obj.get().getUserId())).thenReturn(obj);
		Optional<GuardSalaryEntity> obj1 = Optional.of(service.findByPk(obj.get().getUserId()));
		assertEquals(obj.get().getUserId(),obj1.get().getUserId());
		
	}
	
	
	@Test
	public void testFindByPkWrong() throws RecordNotFoundException
	{
		long userId=123;
		Optional<GuardSalaryEntity> obj =Optional.of(new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now())));
 
		try{
			Mockito.when(dao.findByUserId((int) obj.get().getUserId())).thenReturn(obj);
		Optional<GuardSalaryEntity> obj1 = Optional.of(service.findByPk(obj.get().getUserId()));
		assertEquals(userId,obj1.get().getUserId());
		}
		catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	//test case for searching any value
	@Test
	public void testSearch() throws DatabaseException
	{
		GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
		GuardSalaryEntity obj1 = new GuardSalaryEntity("anshul", 2000,"102","received",Date.valueOf(LocalDate.now()));
		
		List<GuardSalaryEntity> list1  = new ArrayList();
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
	GuardSalaryEntity obj = new GuardSalaryEntity("aravind", 2000,"101","credited",Date.valueOf(LocalDate.now()));
	GuardSalaryEntity obj1 = new GuardSalaryEntity("anshul", 2000,"102","received",Date.valueOf(LocalDate.now()));
	
	List<GuardSalaryEntity> list1  = new ArrayList();
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
