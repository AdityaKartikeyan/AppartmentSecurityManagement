package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.repository.FlatDaoInt;
import com.cg.aps.service.FlatServiceInt;

public class FlatServiceTest {
	@MockBean
	FlatDaoInt dao;
	@Autowired
	FlatServiceInt service;

	@Test
	public void testAddGuardTraining() {

		FlatEntity obj = new FlatEntity("Sahitya", "1041", "10", "3BHK");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}
	
}
