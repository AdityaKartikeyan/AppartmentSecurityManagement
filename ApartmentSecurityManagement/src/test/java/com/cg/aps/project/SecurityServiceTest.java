/**
 * 
 */
package com.cg.aps.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
	
	
	
	
}
