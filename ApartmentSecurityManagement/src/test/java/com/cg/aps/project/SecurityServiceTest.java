/**
 * 
 */
package com.cg.aps.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.entities.SecurityEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.SecurityDao;
import com.cg.aps.service.SecurityService;

/**
 * @author Administrator
 *
 */

@SpringBootTest
public class SecurityServiceTest {

	

	@MockBean
	SecurityDao dao;
	@Autowired
	SecurityService service;
	
	//test add security bean
	@Test
	@DisplayName("Test add security - Correct values entered")
	public void addSecurity() throws DuplicateRecordException
	{
      
		SecurityEntity obj = new SecurityEntity("1","aditya", "harsh");
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
	}
	
	@Test
	@DisplayName("Test add security - duplicate values entered")
	public void testAddExistingSecurityTraining() throws DuplicateRecordException
	{
		String alertId="1";
		SecurityEntity obj = new SecurityEntity("1","aditya", "harsh");
		SecurityEntity obj2 = new SecurityEntity("1","aditya", "harsh");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
		assertEquals(alertId,service.add(obj).getAlertId());
		}
		catch(DuplicateRecordException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Test add security - incorrect values entered")
	public void testAddWrongSecurityTraining() throws DuplicateRecordException
	{
		String alertId="2";
		SecurityEntity obj = new SecurityEntity("1","aditya", "harsh");
		SecurityEntity obj2 = new SecurityEntity("1","aditya", "harsh");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
		assertEquals(alertId,service.add(obj).getAlertId());
		}
		catch(DuplicateRecordException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//test update security bean
	@Test
	public void updateSecurity() throws  RecordNotFoundException
	{

		SecurityEntity obj = new SecurityEntity("1","aditya", "harsh");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {

			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	@Test 
	@DisplayName("Test update guard - null detail entered")
	public void testUpdateSecurityTraining() throws  RecordNotFoundException
	{
		SecurityEntity obj = new SecurityEntity("1","aditya", "harsh");
		Mockito.when(dao.save(obj)).thenReturn(obj);
	    SecurityEntity security = null;
	     try {
	        security=service.update(obj);
	     }
	     catch(RecordNotFoundException e)
	     {
	    	 assertEquals(e.getMessage(),"Message not found");
	     }
	}
	
	@Test
	@DisplayName("Test update guard - incorrect detail entered")
	public void updateSecurityIncorrectDetails() throws  RecordNotFoundException
	{

		SecurityEntity obj = new SecurityEntity("1","aditya", "harsh");
		SecurityEntity obj2 = new SecurityEntity("2","aditya", "harsh");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {

			assertEquals(obj2, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	
	//test delete security bean 
	@Test 
	public void deleteSecurity() throws RecordNotFoundException
	{
		Optional<SecurityEntity> obj1 = Optional.of(new SecurityEntity(1,"1","aditya", null, null, "harsh", null, null));

		  Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		 SecurityEntity src= service.delete(obj1.get().getId());
		 
			  assertEquals(1,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
			 
	}
	
	@Test 
	public void deleteSecurityWrong() throws RecordNotFoundException
	{
		Optional<SecurityEntity> obj1 = Optional.of(new SecurityEntity(1,"1","aditya", null, null, "harsh", null, null));

		  Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		 SecurityEntity src= service.delete(obj1.get().getId());
		 
			  assertEquals(0,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
			 
	}
	
//test find  by id
	@Test
	@DisplayName("Test find by id - correct details entered")
	public void testFindByPk() throws RecordNotFoundException
	{
		
	Optional<SecurityEntity> obj =	Optional.of( new SecurityEntity("1","aditya", "harsh"));
		Mockito.when(dao.findByAlertId(obj.get().getAlertId())).thenReturn(obj);
		Optional<SecurityEntity> obj1 = Optional.of(service.findByPk(obj.get().getAlertId()));
		assertEquals(obj.get().getAlertId(),obj1.get().getAlertId());
		
	}
	
	@Test
	@DisplayName("Test find by id - incorrect details entered")
	public void testFindByPkWrong() throws RecordNotFoundException
	{
		int alertId=3;
		Optional<SecurityEntity> obj =	Optional.of( new SecurityEntity("1","aditya", "harsh"));
		
		try {
			Mockito.when(dao.findByAlertId(obj.get().getAlertId())).thenReturn(obj);
			Optional<SecurityEntity> obj1 = Optional.of(service.findByPk(obj.get().getAlertId()));
		assertEquals(alertId,obj1.get().getAlertId());
		}
		catch(RecordNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	//testing search
		@Test
		@DisplayName("Test search all  - Correct details entered")
		public void testSearch() throws DatabaseException
		{
			SecurityEntity obj = new SecurityEntity("1","aditya", "harsh");
			SecurityEntity obj1 = new SecurityEntity("2","aditya", "harsh");
			List<SecurityEntity> list1  = new ArrayList();
			list1.add(obj);
			list1.add(obj1);
			
			
			Mockito.when(dao.findAll()).thenReturn(list1);
			assertEquals(2,service.search().size());
		}
		
		
		@Test
		@DisplayName("Test search all  - No details entered")
		public void testSearchWrong() throws DatabaseException
		{
			
			List<SecurityEntity> list = new ArrayList<SecurityEntity>();

			List<SecurityEntity> returnedList = new ArrayList<SecurityEntity>();
		

			
			try {
				Mockito.when(dao.findAll()).thenReturn(list);
				returnedList = service.search();
				assertEquals(list,returnedList);
			}
			catch(DatabaseException e)
			{
				assertEquals(e.getMessage(), "No Records available in Database");
			
		}
		
		}
	
		@Test
		@DisplayName("Test search all  - Incorrect details entered")
		public void testSearchWrong1() throws DatabaseException {

			SecurityEntity obj = new SecurityEntity("1", "aditya", "harsh");
			SecurityEntity obj1 = new SecurityEntity("2", "aditya", "harsh");
			List<SecurityEntity> list1 = new ArrayList();
			list1.add(obj);
			list1.add(obj1);

			try {
				Mockito.when(dao.findAll()).thenReturn(list1);
				assertEquals(3, service.search().size());
			} catch (DatabaseException e) {

				e.printStackTrace();

			}

		}
	
	
}
