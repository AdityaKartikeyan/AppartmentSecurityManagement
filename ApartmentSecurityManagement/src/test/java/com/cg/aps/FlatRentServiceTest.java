package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.repository.FlatRentDaoInt;
import com.cg.aps.service.FlatRentServiceInt;

public class FlatRentServiceTest {
	@MockBean
	FlatRentDaoInt dao;
	@Autowired
	FlatRentServiceInt service;

	@Test
	public void testAddGuardTraining() {

		FlatRentEntity obj = new FlatRentEntity("Sahitya", "1041", "5000", "3BHK");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}
	
}
