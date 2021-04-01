package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.DomesticHelpDao;
import com.cg.aps.service.DomesticHelpService;

@SpringBootTest
class DomesticHelpTest {
	@MockBean
	DomesticHelpDao dao;
	@Autowired
	DomesticHelpService service;

	@Test
	 void testAddDomesticHelp() throws DuplicateRecordException {

		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));                 // test add

	} 
	
	@Test
	 void testAddDomesticHelpWrong() throws DuplicateRecordException {
		String helpNo = "7476";
		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", helpNo, helpNo, helpNo);

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(helpNo, service.add(obj).getDomestichelpId());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();                                                //wrong test add
		}
	}
	@Test
	 void testAddExistingDomesticHelp() throws DuplicateRecordException {
		String DomesticHelpNo = "103";
		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", DomesticHelpNo, DomesticHelpNo, DomesticHelpNo);
		DomesticHelpEntity obj1 = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", DomesticHelpNo, DomesticHelpNo, DomesticHelpNo);
		
		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(DomesticHelpNo, service.add(obj).getDomestichelpId());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();                                                   //test existing add
		}
	}
	@Test
	 void testUpdateDomesticHelp() throws RecordNotFoundException {

		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);

		Mockito.when(dao.save(obj)).thenReturn(obj);

		try {
			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();                                                 // update test
		}
	}
	@Test
	 void testUpdateDomesticHelpWrong() throws RecordNotFoundException {
String help="Laundry";
		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", help, help, help);

		Mockito.when(dao.save(obj)).thenReturn(obj);

		try {
			assertEquals(help, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}                                                                        // wrong update test
	}
	@Test
	 void testDomesticHelp() throws RecordNotFoundException {
		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);
		
		Optional<DomesticHelpEntity> obj1 = Optional.of(new DomesticHelpEntity(1,"Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null));
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		try {
			DomesticHelpEntity src = service.delete(obj1.get().getId());

			assertEquals(1, src.getId());
		} catch (RecordNotFoundException e) {                                   // find by id test
			e.printStackTrace();                                                         
		}
	}
	@Test
	 void testDomesticHelpWrong() throws RecordNotFoundException {
		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);
		
		Optional<DomesticHelpEntity> obj1 = Optional.of(new DomesticHelpEntity(1,"Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null));
		Mockito.when(dao.findById(obj1.get().getId())).thenReturn(obj1);
		Mockito.when(dao.deleteById(obj1.get().getId())).thenReturn(obj1.get());
		try {
			DomesticHelpEntity src = service.delete(obj1.get().getId());

			assertEquals(0, src.getId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();                                               // find by id wrong test
		}
	}
	@Test
	 void testFindByName() throws RecordNotFoundException
	{
		
		Optional<DomesticHelpEntity> obj = Optional.of(new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null));

	
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		Optional<DomesticHelpEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
		assertEquals(obj.get().getName(),obj1.get().getName());
		
	}                                                                            // find by name test
	 void testFindByNameWrong() throws RecordNotFoundException
	{
		String name="leo";
		Optional<DomesticHelpEntity> obj = Optional.of(new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", name, name, name));

	try {
		Mockito.when(dao.findByName(obj.get().getName())).thenReturn(obj);
		Optional<DomesticHelpEntity> obj1 = Optional.of(service.findByName(obj.get().getName()));
	
		assertEquals(obj.get().getName(),obj1.get().getName());
	}
	catch (RecordNotFoundException e) {                                            // find by name wrong test
		e.printStackTrace();
	}
		
	}
	@Test
	 void testFindByPk() throws RecordNotFoundException
	{
		
		Optional<DomesticHelpEntity> obj =Optional.of(new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null));
 
		Mockito.when(dao.findByDomesticHelpId( obj.get().getDomestichelpId())).thenReturn(obj);
		Optional<DomesticHelpEntity> obj1 = Optional.of(service.findByPk(obj.get().getDomestichelpId()));
		assertEquals(obj.get().getDomestichelpId(),obj1.get().getDomestichelpId());
		
	}                                                                             //find by pk test
	@Test
 void testFindByPkWrong() throws RecordNotFoundException
	{
		String help="leo";
		
		Optional<DomesticHelpEntity> obj =Optional.of(new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", help, help, help));
 try { 
 
		Mockito.when(dao.findByDomesticHelpId( obj.get().getDomestichelpId())).thenReturn(obj);
		Optional<DomesticHelpEntity> obj1 = Optional.of(service.findByPk(obj.get().getDomestichelpId()));
		assertEquals(obj.get().getDomestichelpId(),obj1.get().getDomestichelpId());
 }
 catch (RecordNotFoundException e) {
		e.printStackTrace();
	}
		
	}                                                                              // find by pk wrong test
	@Test
	 void testSearch() throws DatabaseException
	{
		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);
		DomesticHelpEntity obj1 = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);
		List<DomesticHelpEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2,service.search().size());                                          // test search
	}
	@Test
	 void testSearchWrong() throws DatabaseException
	{
		DomesticHelpEntity obj = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);
		DomesticHelpEntity obj1 = new DomesticHelpEntity(0, "Anant", "Toshniwal", null, null, "11", "AT","Aditya","Laundry", "11:30", null, null, null);
		List<DomesticHelpEntity> list1  = new ArrayList();
		list1.add(obj);
		list1.add(obj1);
		
		
		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(3,service.search().size());
	}                                                                                     // test wrong
}
