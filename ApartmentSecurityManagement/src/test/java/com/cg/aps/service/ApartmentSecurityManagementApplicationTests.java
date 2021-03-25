package com.cg.aps.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

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

	@Test
	public void testAddDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity(1222, "aditya", "digvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), "Vishal", "12:30", Date.valueOf(LocalDate.now()),
				"completed");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));

	}

	@Test
	public void testUpdateDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity(1222, "aditya", "digvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), "Vishal", "12:30", Date.valueOf(LocalDate.now()),
				"completed");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
		obj.setOwnerName("harsh");
		obj.setStatus("working");
		assertEquals(obj, service.update(obj));
	}
}