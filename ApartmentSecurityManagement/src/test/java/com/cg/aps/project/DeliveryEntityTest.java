package com.cg.aps.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.sql.Timestamp;
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
public class DeliveryEntityTest {
	@MockBean
	DeliveryDao dao;
	@Autowired
	DeliveryService service;

	@Test // Testing add method to add delivery entity
	public void testAddDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity(1222, "aditya", "digvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 1, "Vishal", "12:30", Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));

	}

	@Test // Testing update method to update delivery entity
	public void testUpdateDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity(1222, "aditya", "digvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 1, "Vishal", "12:30", Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
		obj.setOwnerName("harsh");
		assertEquals(obj, service.update(obj));
	}

	@Test // Testing delete method to delete delivery entity
	public void testDeleteDeliveryEntity() {

		DeliveryEntity obj = new DeliveryEntity(1222, "aditya", "digvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 1, "Vishal", "12:30", Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		service.delete(obj);
		verify(dao, times(1)).delete(obj);
	}

	@Test // Testing findByName method to find By Name
	public void testFindByName() {
		String name = "aditya";
		DeliveryEntity obj = new DeliveryEntity(1222, "aditya", "digvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 1, "Vishal", "12:30", Date.valueOf(LocalDate.now()));
		Mockito.when(dao.save(obj)).thenReturn(obj);
		DeliveryEntity obj1 = new DeliveryEntity(1223, "Newname", "Tigvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 2, "Nameowner", "10:30", Date.valueOf(LocalDate.now()));

		List<DeliveryEntity> list = new ArrayList<DeliveryEntity>();
		list.add(obj);
		list.add(obj1);

		Mockito.when(dao.findByName(name)).thenReturn(list);
		assertEquals(2, service.findByName(name).size());
	}

	@Test // Testing findByPk method to find By Id
	public void testFindByPk() {
		Optional<DeliveryEntity> obj = Optional.of(new DeliveryEntity(1222, "aditya", "digvijay",
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1, "Vishal",
				"12:30", Date.valueOf(LocalDate.now())));

		Mockito.when(dao.findById((int) obj.get().getDeliveryId())).thenReturn(obj);
		Optional<DeliveryEntity> obj1 = service.findByPk(obj.get().getDeliveryId());
		assertEquals(obj.get().getDeliveryId(), obj1.get().getDeliveryId());
	}
	
	@Test // Testing Search method to find all
	public void testSearch() {
		DeliveryEntity obj = new DeliveryEntity(1222, "aditya", "digvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 1, "Vishal", "12:30", Date.valueOf(LocalDate.now()));
		DeliveryEntity obj1 = new DeliveryEntity(1223, "Newname", "Tigvijay", new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), 2, "Nameowner", "10:30", Date.valueOf(LocalDate.now()));
		List<DeliveryEntity> list1 = new ArrayList();
		list1.add(obj);
		list1.add(obj1);

		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2, service.search().size());
	}
}