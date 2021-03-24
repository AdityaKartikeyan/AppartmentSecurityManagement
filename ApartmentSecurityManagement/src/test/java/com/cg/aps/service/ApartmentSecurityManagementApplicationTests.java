package com.cg.aps.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.repository.DeliveryDao;

@SpringBootTest
public class ApartmentSecurityManagementApplicationTests {
	@MockBean
	DeliveryDao dao;
	@Autowired
	DeliveryService service;

//	@Test
	/*public void testAddDelivery() {

		DeliveryEntity obj = new DeliveryEntity("name",null,null,null);
		Mockito.when(dao.save(obj)).thenReturn(obj);
		long result = service.add(obj);
		assertEquals(obj.getId(),obj.getId());
	
	}*/
}
