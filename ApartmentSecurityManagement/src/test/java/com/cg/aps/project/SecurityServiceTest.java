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
      
		SecurityEntity obj = new SecurityEntity(11, "aditya", "harsh",new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1, "intruder", "door", LocalDate.now());
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj,service.add(obj));
			
	}
	
	//test update security bean
	@Test
	public void updateSecurity()
	{
		SecurityEntity obj = new SecurityEntity(11, "aditya", "harsh",new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1, "intruder", "door", LocalDate.now());
	    Mockito.when(dao.save(obj)).thenReturn(obj);

	    assertEquals(obj,service.add(obj));
	    
	    obj.setAlertMessage("no intruder");
	     
	     assertEquals(obj,service.update(obj));
	}
	
	//test delete security bean 
	@Test 
	public void deleteSecurity()
	{
		SecurityEntity obj = new SecurityEntity(11, "aditya", "harsh",new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1, "intruder", "door", LocalDate.now());
	    service.delete(obj);
	    verify(dao,times(1)).delete(obj);
	}
	
//test find  by name
	@Test
	public void testFindByPk()
	{
		
	Optional<SecurityEntity> obj =	Optional.of(new SecurityEntity(11, "aditya", "harsh",new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1, "intruder", "door", LocalDate.now()));
		Mockito.when(dao.findById(obj.get().getAlertId())).thenReturn(obj);
		Optional<SecurityEntity> obj1 = service.findByPk(obj.get().getAlertId());
		assertEquals(obj.get().getAlertId(),obj1.get().getAlertId());
		
	}
	
	
	//testing search
		@Test
		public void testSearch()
		{
			SecurityEntity obj = new SecurityEntity(12, "aditya", "harsh",new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 2, "intruder", "door", LocalDate.now());
			SecurityEntity obj1 = new SecurityEntity(11, "aditya", "harsh",new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1, "intruder", "door", LocalDate.now());
			List<SecurityEntity> list1  = new ArrayList();
			list1.add(obj);
			list1.add(obj1);
			
			
			Mockito.when(dao.findAll()).thenReturn(list1);
			assertEquals(2,service.search().size());
		}
		
	
	
	
}
