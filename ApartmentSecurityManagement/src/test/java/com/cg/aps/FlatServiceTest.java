package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatDaoInt;
import com.cg.aps.service.FlatServiceInt;

@SpringBootTest

 class FlatServiceTest {
	@MockBean
	FlatDaoInt dao;
	@Autowired
	FlatServiceInt service;

	@Test
	 void testAddFlat() throws DuplicateRecordException {

		FlatEntity obj = new FlatEntity("Sahitya", "1041", "owner", "1041b");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}

	@Test
	 void testAddFlatWrong() throws DuplicateRecordException {
		String flatNo = "7476";
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");


		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(flatNo, service.add(obj).getFlatNo());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
	@Test
	 void testAddFlatDuplicate() throws DuplicateRecordException {
		String flatNo = "1041b";
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");
		FlatEntity obj1 = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(flatNo,service.add(obj).getFlatNo());
			}
			catch(DuplicateRecordException e)
			{
				e.printStackTrace();
			}
	}
	
	@Test 
	 void testUpdateFlat() throws  RecordNotFoundException
	{
		
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");
	
	   
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
	 void testUpdateFlatWrong() throws RecordNotFoundException {
		String flatNo = "1041b";
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");
				

		Mockito.when(dao.save(obj)).thenReturn(obj);

		try {
			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	  

	@Test
	 void testDeleteFlat() throws RecordNotFoundException {
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");
				
		Optional<FlatEntity> obj1 = Optional.of(new FlatEntity(1, "Sahitya", "shrivastava", null, null, "Owner", "1041b", null, null));
				
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		try {
		FlatEntity src = service.delete(obj1.get().getId());

			assertEquals(1, src.getId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	 void testDeleteFlatWrong() throws RecordNotFoundException {
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");
				
		Optional<FlatEntity> obj1 = Optional.of(new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b"));
				
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		try {
		FlatEntity src = service.delete(obj1.get().getId());

			assertEquals(0, src.getId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testFindByName() throws RecordNotFoundException
	{
		
	
		Optional<FlatEntity> obj = Optional.of(new FlatEntity("Sahitya", "1041", "owner", "1041b"));
	 
	Mockito.when(dao.findByOwnerName( obj.get().getOwnerName())).thenReturn(obj);
	Optional<FlatEntity> obj1 = Optional.of(service.findByName(obj.get().getOwnerName()));
	assertEquals(obj.get().getOwnerName(),obj1.get().getOwnerName());
	}
	
	@Test
	 void testFindByNameWrong() throws RecordNotFoundException
	{
		
	String ownerName= "aditya";
	Optional<FlatEntity> obj =Optional.of(new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b"));
	try { 
	Mockito.when(dao.findByOwnerName( obj.get().getOwnerName())).thenReturn(obj);
	Optional<FlatEntity> obj1 = Optional.of(service.findByName(obj.get().getOwnerName()));
	assertEquals(ownerName ,obj1.get().getOwnerName());}
	catch(RecordNotFoundException e)
	 {
		 e.printStackTrace();
	 }
	}
	@Test
	 void testFindByPk() throws RecordNotFoundException
	{
		
		Optional<FlatEntity> obj =Optional.of(new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b"));
 
		Mockito.when(dao.findByFlatNo( obj.get().getFlatNo())).thenReturn(obj);
		Optional<FlatEntity> obj1 = Optional.of(service.findByPk(obj.get().getFlatNo()));
		assertEquals(obj.get().getId(),obj1.get().getId());
		
	}
	@Test
	 void testFindByPkWrong() throws RecordNotFoundException
	{
		String FlatNo= "1245";
		Optional<FlatEntity> obj =Optional.of(new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b"));
		try { 
		Mockito.when(dao.findByFlatNo( obj.get().getFlatNo())).thenReturn(obj);
		Optional<FlatEntity> obj1 = Optional.of(service.findByPk(obj.get().getFlatNo()));
		assertEquals(FlatNo ,obj1.get().getFlatNo());}
		catch(RecordNotFoundException e)
		 {
			 e.printStackTrace();
		 }
	}

	@Test
	 void testSearch() throws DatabaseException
	{
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");
		FlatEntity obj1 = new FlatEntity("Anshul", "paaji", "Owner", "1042");	
		List<FlatEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
	}
	
	@Test
	 void testSearchWrong() throws DatabaseException
	{
		FlatEntity obj = new FlatEntity("Sahitya", "shrivastava", "Owner", "1041b");
		FlatEntity obj1 = new FlatEntity("Anshul", "paaji", "Owner", "1042");	
		List<FlatEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		try {
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(3,service.search().size());
		}
		catch(DatabaseException e)
		{
			e.printStackTrace();
		}
	}
}
