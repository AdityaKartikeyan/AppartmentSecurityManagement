package com.cg.aps.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
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
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GuardTrainingDao;
import com.cg.aps.service.GuardTrainingService;

//testing

@SpringBootTest
class GuardTrainingServiceTest {

	@MockBean
	GuardTrainingDao dao;
	@Autowired
	GuardTrainingService service;
	
	//adding correct details
	@Test
	@DisplayName("Test add guard - correct values entered")
	public void testAddGuardTraining() throws DuplicateRecordException
	{
		
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}
		
	//adding duplicate details
	@Test
	@DisplayName("Test add guard - duplicate values entered")
	public void testAddExistingGuardTraining() throws DuplicateRecordException
	{
		long userId=1;
		GuardTrainingEntity obj = new GuardTrainingEntity(1, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now()));
		GuardTrainingEntity obj1 = new GuardTrainingEntity(1, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
		assertEquals(userId,service.add(obj).getUserId());
		
		}
		catch(DuplicateRecordException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	@DisplayName("Test add guard - incorrect values entered")
	public void testAddWrongGuardTraining() throws DuplicateRecordException
	{
		int userId=2;
		GuardTrainingEntity obj = new GuardTrainingEntity(1, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now()));
		//GuardTrainingEntity obj1 = new GuardTrainingEntity(1, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
		assertEquals(userId,service.add(obj).getUserId());
		}
		catch(DuplicateRecordException e)
		{
			e.printStackTrace();
		}
		
	}
	
	

	
	//testing update guard training entity
	@Test
	@DisplayName("Test update guard - correct values entered")
	public void testUpdateGuardTraining() throws DuplicateRecordException, RecordNotFoundException {

		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya", "digvijay", "HARSH", "981899",
				Date.valueOf(LocalDate.now()));

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {

			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}

	}
	
//putting incorrect details
	@Test 
	@DisplayName("Test update guard - null detail entered")
	public void testUpdate2GuardTraining() throws DuplicateRecordException, RecordNotFoundException
	{
		
		GuardTrainingEntity obj = new GuardTrainingEntity(1222," ","701147419" ,"joined","11.30",Date.valueOf(LocalDate.now()));
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);
	    GuardTrainingEntity guard = null;
	     try {
	        guard=service.update(obj);
	     }
	     catch(RecordNotFoundException e)
	     {
	    	 assertEquals(e.getMessage(),"Name not found");
	     }
	}
	
	@Test 
	@DisplayName("Test update guard - incorrect detail entered")
	public void testUpdateWrongGuardTraining() throws DuplicateRecordException, RecordNotFoundException
	{
		
		
		GuardTrainingEntity obj = new GuardTrainingEntity(1222," ","701147419" ,"joined","11.30",Date.valueOf(LocalDate.now()));
		GuardTrainingEntity obj2 = new GuardTrainingEntity(2312," ","701147419" ,"joined","11.30",Date.valueOf(LocalDate.now()));
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);
	    
	     try {
	    	 assertEquals(obj2, service.update(obj));
	     }
	     catch(RecordNotFoundException e)
	     {
	    	 e.printStackTrace();
	     }
	}
	
	
	
	
	
	//testing delete guard training entity
	@Test
	@DisplayName("Test delete guard - correct detail entered")
	public void testDeleteGuardTraining() throws RecordNotFoundException
	{
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now()));
		Optional<GuardTrainingEntity> obj1 = Optional.of(new GuardTrainingEntity(1, null, null, null,
				null, 0, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now())));
		
		
		  Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		  GuardTrainingEntity src= service.delete(obj1.get().getId());
		 
			  assertEquals(1,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
			 
		
		// verify(dao,times(1)).deleteById(obj.getId());
	
	 
	}
	
	@Test
	@DisplayName("Test delete guard - incorrect detail entered")
	public void testDeleteGuardTrainingWrong() throws RecordNotFoundException
	{
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now()));
		Optional<GuardTrainingEntity> obj1 = Optional.of(new GuardTrainingEntity(1, null, null, null,
				null, 0, "aditya","digvijay" ,"HARSH","981899",Date.valueOf(LocalDate.now())));
		
		
		
		  Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		 GuardTrainingEntity src= service.delete(obj1.get().getId());
		 assertEquals(0,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
			 
		 
		
	
	 
	}

	//testing find by name guard training entity
	//test case positive
	@Test
	@DisplayName("Test find by name - correct details entered")
	public void testFindByName() throws RecordNotFoundException
	{
		Optional<GuardTrainingEntity> obj =Optional.of(new GuardTrainingEntity(1222, "aditya","digvijay" ,"aditya","981899",Date.valueOf(LocalDate.now())));
		 
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		Optional<GuardTrainingEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(obj.get().getName(),obj1.get().getName());
		
		
	}
	
	//test case negative 
	@Test
	@DisplayName("Test find by name - incorrect details entered")
	public void testFindByName1() throws RecordNotFoundException
	{
		String name="raju";
		Optional<GuardTrainingEntity> obj =Optional.of(new GuardTrainingEntity(1222, "aditya","digvijay" ,"aditya","981899",Date.valueOf(LocalDate.now())));
		 try {
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		Optional<GuardTrainingEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(name,obj1.get().getName());
		 }
		 catch(RecordNotFoundException e)
		 {
			 e.printStackTrace();
		 }
	}
	//testing find by id 
	@Test
	@DisplayName("Test find by id - correct details entered")
	public void testFindByPk() throws RecordNotFoundException
	{
		
		Optional<GuardTrainingEntity> obj =Optional.of(new GuardTrainingEntity(1222, "aditya","digvijay" ,"aditya","981899",Date.valueOf(LocalDate.now())));
 
		Mockito.when(dao.findByUserId(obj.get().getUserId())).thenReturn(obj);
		Optional<GuardTrainingEntity> obj1 = Optional.of(service.findByPk(obj.get().getUserId()));
		assertEquals(obj.get().getUserId(),obj1.get().getUserId());
		
	}
	
	@Test
	@DisplayName("Test find by id - incorrect details entered")
	public void testFindByPkWrong() throws RecordNotFoundException
	{
		int getId=3;
		Optional<GuardTrainingEntity> obj =Optional.of(new GuardTrainingEntity(2, "aditya","digvijay" ,"aditya","981899",Date.valueOf(LocalDate.now())));
 
		
		try {
			Mockito.when(dao.findByUserId(obj.get().getUserId())).thenReturn(obj);
			Optional<GuardTrainingEntity> obj1 = Optional.of(service.findByPk(obj.get().getUserId()));
		assertEquals(getId,obj1.get().getUserId());
		}
		catch(RecordNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	//testing search
	@Test
	@DisplayName("Test search all  - correct details entered")
	public void testSearch() throws DatabaseException
	{
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,"aditya","981899",Date.valueOf(LocalDate.now()));
		GuardTrainingEntity obj1 = new GuardTrainingEntity(1225, "harsh","hello" ,"aditya","981899",Date.valueOf(LocalDate.now()));
		List<GuardTrainingEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
	}
	
	
	@Test
	@DisplayName("Test search all  - No details entered")
	public void testSearchNull() throws DatabaseException
	{
		
		List<GuardTrainingEntity> list = new ArrayList<GuardTrainingEntity>();

		List<GuardTrainingEntity> returnedList = new ArrayList<GuardTrainingEntity>();
	

		
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
	@DisplayName("Test search all  - incorrect details entered")
	public void testSearchWrong() throws DatabaseException
	{
		GuardTrainingEntity obj = new GuardTrainingEntity(1222, "aditya","digvijay" ,"aditya","981899",Date.valueOf(LocalDate.now()));
		GuardTrainingEntity obj1 = new GuardTrainingEntity(1225, "harsh","hello" ,"aditya","981899",Date.valueOf(LocalDate.now()));
		List<GuardTrainingEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		try {
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(3,service.search().size());
		}
		catch(DatabaseException e)
		{
			assertEquals(e.getMessage(), "No Records available in Database");
		
	}
		
	}
	
}
