package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
				new Timestamp(System.currentTimeMillis()), "11", "AT","Aditya","Laundry", "11:30","12:30", "27/03/2021");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));

	} 
	
	@Test
	public void testDomesticHelp1() {

			DomesticHelpEntity obj = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
	new Timestamp(System.currentTimeMillis()), "11", "AT","Aditya","Laundry", "11:30","12:30", "27/03/2021");

		Mockito.when(dao.save(obj)).thenReturn(obj);

		assertEquals(obj, service.add(obj));

		obj.setName("Joshi");
		obj.setArrivalTime("11:30");
   //	obj.setStatus("working");

		assertEquals(obj, service.update(obj));
	}
	@Test
	public void testDomesticHelp() {
		DomesticHelpEntity obj = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), "11", "AT","Aditya","Laundry", "11:30","12:30", "27/03/2021");

		service.delete(obj.getId());
		verify(dao, times(1)).deleteById((int) obj.getId());
	}
	@Test
	public void testFindByName()
	{
		String name="Anant";
		DomesticHelpEntity obj = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), "11", "AT","Aditya","Laundry", "11:30","12:30", "27/03/2021");
		DomesticHelpEntity obj1 = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), "11", "AT","Aditya","Laundry", "11:30","12:30", "27/03/2021");
	 List<DomesticHelpEntity> list  = new ArrayList();
	list.add(obj);
	list.add(obj1);
	
		Mockito.when(dao.findByName(name)).thenReturn(list);
		assertEquals(2,service.findByName(name).size());
		
	}
	@Test
	public void testFindByPk()
	{
		
		Optional<DomesticHelpEntity> obj =Optional.of(new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), "11", "AT","Aditya","Laundry", "11:30","12:30", "27/03/2021"));
 
		Mockito.when(dao.findById((int) obj.get().getId())).thenReturn(obj);
		Optional<DomesticHelpEntity> obj1 = service.findByPk(obj.get().getId());
		assertEquals(obj.get().getId(),obj1.get().getId());
		
	}
//	@Test
//	public void testSearch()
//	{
//		DomesticHelpEntity obj = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
//				new Timestamp(System.currentTimeMillis()), 11, "AT", "11:30", Date.valueOf(LocalDate.now()));
//		DomesticHelpEntity obj1 = new DomesticHelpEntity(12, "Anant", "Toshniwal", new Timestamp(System.currentTimeMillis()),
//				new Timestamp(System.currentTimeMillis()), 11, "AT", "11:30", Date.valueOf(LocalDate.now()));
//		List<DomesticHelpEntity> list1  = new ArrayList();
//		list1.add(obj);
//		list1.add(obj1);
//		
//		
//		Mockito.when(dao.findAll()).thenReturn(list1);
//		assertEquals(2,service.search().size());
//	}
}