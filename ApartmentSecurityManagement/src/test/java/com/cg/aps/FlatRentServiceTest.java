package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.FlatRentEntity;
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
	public void testAddFlatRent() {

		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1041b", "5200", "3BHK");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}
	
	@Test 
	public void testUpdateFlatRent()
	{
		
		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1041b", "5200", "3BHK");
	
	   
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    assertEquals(obj,service.add(obj));
	    
	    obj.setAmount("5002");
	    obj.setFlatNo("1041b");
	     
	      assertEquals(obj,service.update(obj));
}
	
	@Test
	public void testDeleteFlatRent()
	{
		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1041b", "5200", "3BHK");
	    service.delete(obj);
	    verify(dao,times(1)).delete(obj);
	}
	
	@Test
	public void testFindByName()
	{
		String name="Sahitya";
		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1041b", "5200", "3BHK");
		FlatRentEntity obj1 = new FlatRentEntity(102, "Anshul", "paaji", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1042", "5300", "3BHK");		
	 List<FlatRentEntity> list  = new ArrayList();
	list.add(obj);
	list.add(obj1);
	
		Mockito.when(dao.findByOwnerName(name)).thenReturn(list);
		assertEquals(2,service.findByName(name).size());
		
	}
	
	@Test
	public void testFindByPk()
	{
		
		Optional<FlatRentEntity> obj =Optional.of(new FlatRentEntity(101, "Sahitya", "shrivastava", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1041b", "5200", "3BHK"));
 
		Mockito.when(dao.findById( obj.get().getFlatNo())).thenReturn(obj);
		Optional<FlatRentEntity> obj1 = service.findByPk(obj.get().getFlatNo());
		assertEquals(obj.get().getFlatNo(),obj1.get().getFlatNo());
		
	}
	
	@Test
	public void testSearch()
	{
		FlatRentEntity obj = new FlatRentEntity(101, "Sahitya", "shrivastava", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1041b", "5200", "3BHK");
		FlatRentEntity obj1 = new FlatRentEntity(102, "Anshul", "paaji", LocalDateTime.now(), LocalDateTime.now(), "Owner", "1042", "5300", "3BHK");	
		List<FlatRentEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());
	}
}
