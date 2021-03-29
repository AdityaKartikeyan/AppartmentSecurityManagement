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

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.entities.SecurityEntity;
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
	public void addSecurity()
	{
      
		SecurityEntity obj = new SecurityEntity("aditya", "harsh");
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
	}
	
	//test update security bean
	@Test
	public void updateSecurity()
	{
		SecurityEntity obj = new SecurityEntity("aditya", "harsh");
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    assertEquals(obj,service.add(obj));
	    
	    obj.setAlertMessage("no intruder");
	     
	     assertEquals(obj,service.update(obj));
	}
	
	//test delete security bean 
	@Test 
	public void deleteSecurity()
	{
		SecurityEntity obj = new SecurityEntity("aditya", "harsh");
	    service.delete(obj.getId());
	    verify(dao,times(1)).deleteById(obj.getId());
	}
	
//test find  by name
	@Test
	public void testFindByPk()
	{
		
	Optional<SecurityEntity> obj =	Optional.of(new SecurityEntity("aditya", "harsh"));
		Mockito.when(dao.findById(obj.get().getId())).thenReturn(obj);
		Optional<SecurityEntity> obj1 = service.findByPk(obj.get().getId());
		assertEquals(obj.get().getId(),obj1.get().getId());
		
	}
	
	
	//testing search
		@Test
		public void testSearch()
		{
			SecurityEntity obj = new SecurityEntity("aditya", "harsh");
			SecurityEntity obj1 = new SecurityEntity("aditya", "harsh");
			List<SecurityEntity> list1  = new ArrayList();
			list1.add(obj);
			list1.add(obj1);
			
			
			Mockito.when(dao.findAll()).thenReturn(list1);
			assertEquals(2,service.search().size());
		}
		
	
	
	
}
