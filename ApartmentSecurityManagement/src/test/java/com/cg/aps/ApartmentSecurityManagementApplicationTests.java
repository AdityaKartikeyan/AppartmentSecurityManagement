package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.repository.DomesticHelpDao;
import com.cg.aps.service.DomesticHelpService;

@SpringBootTest
class ApartmentSecurityManagementApplicationTests {
	@MockBean
	DomesticHelpDao dao;
	@Autowired
	DomesticHelpService service;

	@Test
	public void testAddDomesticHelp() {

		DomesticHelpEntity obj = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 11, "AT", "11:30", Date.valueOf(LocalDate.now()));

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));

	} 
}