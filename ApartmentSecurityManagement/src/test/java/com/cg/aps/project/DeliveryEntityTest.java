package com.cg.aps.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.repository.DeliveryDao;
import com.cg.aps.service.DeliveryService;

/**
 * @author Vishal Rana
 *
 */
@SpringBootTest
class DeliveryEntityTest {
	@MockBean
	DeliveryDao dao;
	@Autowired
	DeliveryService service;

	@Test // Testing add method to add delivery entity
	void testAddDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity("Akhil", "Diljit", Date.valueOf(LocalDate.now()), "New Delivery Added");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));

	}

	@Test // Testing update method to update delivery entity
	void testUpdateDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity("Akhil", "Diljit", Date.valueOf(LocalDate.now()), "New Delivery Added");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
		obj.setOwnerName("harsh");
		assertEquals(obj, service.update(obj));
	}

	@Test // Testing delete method to delete delivery entity
	void testDeleteDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity("Akhil", "Diljit", Date.valueOf(LocalDate.now()), "New Delivery Added");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		service.delete(obj.getId());
		verify(dao, times(1)).deleteById(obj.getId());
	}

	@Test // Testing findByName method to find By Name
	void testFindByOnwerName() {

		String name = "Akhil";
		DeliveryEntity obj = new DeliveryEntity("Akhil", "Diljit", Date.valueOf(LocalDate.now()), "New Delivery Added");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		DeliveryEntity obj1 = new DeliveryEntity("Karan", "Akhil", Date.valueOf(LocalDate.now()), "New Delivery Added");

		List<DeliveryEntity> list = new ArrayList<DeliveryEntity>();
		list.add(obj);
		list.add(obj1);

		Mockito.when(dao.findByOwnerName(name)).thenReturn(list);
		assertEquals(2, service.findByOwnerName(name).size());
	}

	@Test // Testing findByPk method to find By Id void testFindByPk() {
	void testFindByPk() {

		Optional<DeliveryEntity> obj = Optional
				.of(new DeliveryEntity("Akhil", "Diljit", Date.valueOf(LocalDate.now()), "New Delivery Added"));

		Mockito.when(dao.findById(obj.get().getId())).thenReturn(obj);
		Optional<DeliveryEntity> obj1 = service.findByPk(obj.get().getId());
		assertEquals(obj.get().getId(), obj1.get().getId());
	}

	@Test // Testing Search method to find all
	void testSearch() {

		DeliveryEntity obj = new DeliveryEntity("Akhil", "Diljit", Date.valueOf(LocalDate.now()), "New Delivery Added");
		Mockito.when(dao.save(obj)).thenReturn(obj);
		DeliveryEntity obj1 = new DeliveryEntity("Karan", "Akhil", Date.valueOf(LocalDate.now()), "New Delivery Added");

		List<DeliveryEntity> list1 = new ArrayList<DeliveryEntity>();
		list1.add(obj);
		list1.add(obj1);

		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2, service.search().size());
	}
}