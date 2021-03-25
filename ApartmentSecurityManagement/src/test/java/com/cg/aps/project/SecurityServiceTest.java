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
	
	

	
	
	
}
