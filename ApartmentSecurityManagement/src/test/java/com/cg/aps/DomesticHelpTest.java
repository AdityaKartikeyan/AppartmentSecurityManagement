package com.cg.aps;

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

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.repository.DomesticHelpDao;
import com.cg.aps.service.DomesticHelpService;

@SpringBootTest
class DomesticHelpTest {
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
	
	@Test
	public void testDomesticHelp1() {

		DomesticHelpEntity obj = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 11, "AT", "11:30", Date.valueOf(LocalDate.now()));

		Mockito.when(dao.save(obj)).thenReturn(obj);

		assertEquals(obj, service.add(obj));

		obj.setName("Joshi");
		obj.setId(2);
//		obj.setStatus("working");

		assertEquals(obj, service.update(obj));
	}
	@Test
	public void testDomesticHelp() {
		DomesticHelpEntity obj = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 11, "AT", "11:30", Date.valueOf(LocalDate.now()));
		service.delete(obj.getId());
		verify(dao, times(1)).deleteById((int) obj.getId());
	}
}
