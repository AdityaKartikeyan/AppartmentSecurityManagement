package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
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
	
	public void testAddGuardShiftTraining() throws DuplicateRecordException
	{
		
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
		
		
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
		
	}
	@Test
	public void testAddGuardShiftWrong() throws DuplicateRecordException {
		String guardno = "7476";
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(guardno, service.add(obj).getUserId());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddExistingGuardShift() throws DuplicateRecordException {
		String guardno = "103";
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
		GuardShiftEntity obj1 = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(guardno, service.add(obj).getUserId());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	//testing update
	
	@Test 
	public void testUpdateGuardShiftTraining() throws RecordNotFoundException
	{
		
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    try {
	    	assertEquals(obj,service.update(obj));
			}
			catch(RecordNotFoundException e)
			{
				e.printStackTrace();
			}
	}
	
	@Test 
	public void testUpdateGuardShiftTrainingWrong() throws RecordNotFoundException
	{
		String GuardName = "Aman";
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    try {
	    	assertEquals(obj,service.update(obj));
			}
			catch(RecordNotFoundException e)
			{
				e.printStackTrace();
			}
	}
	@Test 
	
	public void testDeleteGuardShiftTraining() throws RecordNotFoundException
	{
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
		Optional<GuardShiftEntity> obj1 = Optional.of(new GuardShiftEntity(1,null, null, null, null, 7, "yash", "aditya", Date.valueOf(LocalDate.now())));
		//service.delete(obj.getUserId());
	    //verify(dao,times(1)).deleteById(obj.getUserId());
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		  GuardShiftEntity src= service.delete(obj1.get().getId());
		 
			  assertEquals(1,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
	}
@Test 
	
	public void testDeleteGuardShiftWrongTraining() throws RecordNotFoundException
	{
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
		Optional<GuardShiftEntity> obj1 = Optional.of(new GuardShiftEntity(1,null, null, null, null, 7, "yash", "aditya", Date.valueOf(LocalDate.now())));
		//service.delete(obj.getUserId());
	    //verify(dao,times(1)).deleteById(obj.getUserId());
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		  Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		  try {
		  GuardShiftEntity src= service.delete(obj1.get().getId());
		 
			  assertEquals(0,src.getId());
		  }
		  catch(RecordNotFoundException e)
		     {
		    	 e.printStackTrace();
		     }
	}

	
	@Test
	public void testFindByName() throws RecordNotFoundException
	{
		Optional<GuardShiftEntity> obj = Optional.of(
				new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now())));
		
	
	
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		Optional<GuardShiftEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(obj.get().getName(),obj1.get().getName());
		
	}
	
	@Test
	public void testFindByNameWrong() throws RecordNotFoundException
	{
		String Name= "Anant Bhaiya";
		Optional<GuardShiftEntity> obj = Optional.of(
				new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now())));
		
	
	try {
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		
		Optional<GuardShiftEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(Name,obj1.get().getName());}
	catch(RecordNotFoundException e)
	 {
		 e.printStackTrace();
	 }
		
	}
	@Test
	public void testFindByPk() throws RecordNotFoundException
	{
		
		Optional<GuardShiftEntity> obj =Optional.of(new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now())));
 
		Mockito.when(dao.findByUserId( obj.get().getUserId())).thenReturn(obj);
		Optional<GuardShiftEntity> obj1 = Optional.of(service.findByPk(obj.get().getUserId()));
		assertEquals(obj.get().getUserId(),obj1.get().getUserId());
		
	}
	@Test
	public void testFindByPkWrong() throws RecordNotFoundException
	{
		String GuardShiftNumber = "169";
		Optional<GuardShiftEntity> obj =Optional.of(new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now())));
 try {
		Mockito.when(dao.findByUserId( obj.get().getUserId())).thenReturn(obj);
		Optional<GuardShiftEntity> obj1 = Optional.of(service.findByPk(obj.get().getUserId()));
		assertEquals(GuardShiftNumber,obj1.get().getUserId());}
 catch(RecordNotFoundException e)
 {
	 e.printStackTrace();
 }	
	}
	@Test
	public void testSearch() throws DatabaseException
	{
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
		GuardShiftEntity obj1 = new GuardShiftEntity(1, "pk", "ankit", Date.valueOf(LocalDate.now()));
		List<GuardShiftEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
	}
	@Test
	public void testSearchWrong() throws DatabaseException
	{
		GuardShiftEntity obj = new GuardShiftEntity(1, "yash", "aditya", Date.valueOf(LocalDate.now()));
		GuardShiftEntity obj1 = new GuardShiftEntity(1, "pk", "ankit", Date.valueOf(LocalDate.now()));
		List<GuardShiftEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(3,service.search().size());
	}
}
