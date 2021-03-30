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

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatRentDaoInt;
import com.cg.aps.service.FlatRentServiceInt;

//@RunWith(SpringRunner.class)
/**
 * @author sahis
 *
 */
@SpringBootTest
public class FlatRentServiceTest {
	@MockBean
	FlatRentDaoInt dao;
	@Autowired
	FlatRentServiceInt service;

	@Test
	public void testAddFlatRent() throws DuplicateRecordException {

		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}
	
	@Test
	public void testAddFlatRentWrong() throws DuplicateRecordException {
		String flatNo = "7476";
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");


		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(flatNo, service.add(obj).getFlatNo());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testAddFlatRentDuplicate() throws DuplicateRecordException {
		String flatNo = "1041b";
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");
		FlatRentEntity obj1 = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");

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
	public void testUpdateFlatRent() throws  RecordNotFoundException
	{
		
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");
	
	   
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
	public void testUpdateFlatRentwrong() throws RecordNotFoundException {
		String flatNo = "1041b";
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");
				

		Mockito.when(dao.save(obj)).thenReturn(obj);

		try {
			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	  
	
	@Test
	public void testDeleteFlatRent() throws RecordNotFoundException {
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");
				
		Optional<FlatRentEntity> obj1 = Optional.of(new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b"));
				
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		try {
		FlatRentEntity src = service.delete(obj1.get().getId());

			assertEquals(1, src.getId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteFlatRentWrong() throws RecordNotFoundException {
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");
				
		Optional<FlatRentEntity> obj1 = Optional.of(new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b"));
				
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		try {
		FlatRentEntity src = service.delete(obj1.get().getId());

			assertEquals(0, src.getId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindByName() throws RecordNotFoundException
	{
		
	
	Optional<FlatRentEntity> obj =Optional.of(new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b"));
	 
	Mockito.when(dao.findByOwnerName( obj.get().getOwnerName())).thenReturn(obj);
	Optional<FlatRentEntity> obj1 = Optional.of(service.findByName(obj.get().getOwnerName()));
	assertEquals(obj.get().getOwnerName(),obj1.get().getOwnerName());
	}
	
	@Test
	public void testFindByNameWrong() throws RecordNotFoundException
	{
		
	String ownerName= "aditya";
	Optional<FlatRentEntity> obj =Optional.of(new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b"));
	try { 
	Mockito.when(dao.findByOwnerName( obj.get().getOwnerName())).thenReturn(obj);
	Optional<FlatRentEntity> obj1 = Optional.of(service.findByName(obj.get().getOwnerName()));
	assertEquals(ownerName ,obj1.get().getOwnerName());}
	catch(RecordNotFoundException e)
	 {
		 e.printStackTrace();
	 }
	}
	
	@Test
	public void testFindByPk() throws RecordNotFoundException
	{
		
		Optional<FlatRentEntity> obj =Optional.of(new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b"));
 
		Mockito.when(dao.findByFlatNo( obj.get().getFlatNo())).thenReturn(obj);
		Optional<FlatRentEntity> obj1 = Optional.of(service.findByPk(obj.get().getFlatNo()));
		assertEquals(obj.get().getId(),obj1.get().getId());
		
	}
	@Test
	public void testFindByPkWrong() throws RecordNotFoundException
	{
		String FlatNo= "1245";
		Optional<FlatRentEntity> obj =Optional.of(new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b"));
		try { 
		Mockito.when(dao.findByFlatNo( obj.get().getFlatNo())).thenReturn(obj);
		Optional<FlatRentEntity> obj1 = Optional.of(service.findByPk(obj.get().getFlatNo()));
		assertEquals(FlatNo ,obj1.get().getFlatNo());}
		catch(RecordNotFoundException e)
		 {
			 e.printStackTrace();
		 }
	}
	
	@Test
	public void testSearch() throws DatabaseException
	{
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");
		FlatRentEntity obj1 = new FlatRentEntity("Anshul", "paaji", "Owner", "1042");	
		List<FlatRentEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
	}
	
	@Test
	public void testSearchWrong() throws DatabaseException
	{
		FlatRentEntity obj = new FlatRentEntity("Sahitya", "shrivastava", "Owner", "1041b");
		FlatRentEntity obj1 = new FlatRentEntity("Anshul", "paaji", "Owner", "1042");	
		List<FlatRentEntity> list1  = new ArrayList();
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
