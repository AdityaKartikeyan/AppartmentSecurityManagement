package com.cg.aps.project;

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

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
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

	/**
	 * @throws DuplicateRecordException
	 */
	@Test // Adding delivery
	void testAddDelivery() throws DuplicateRecordException {

		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}

	/**
	 * @throws DuplicateRecordException
	 */
	@Test // Adding delivery false case
	void testAddDeliveryWrong() throws DuplicateRecordException {
		long deliveryId = 2;
		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(deliveryId, service.add(obj).getDeliveryId());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws DuplicateRecordException
	 */
	@Test // Adding delivery to existing delivery
	void testAddExistingDelivery() throws DuplicateRecordException {
		long deliveryId = 1;
		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		DeliveryEntity obj1 = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		Mockito.when(dao.save(obj1)).thenReturn(obj1);
		try {
			assertEquals(deliveryId, service.add(obj).getDeliveryId());
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws RecordNotFoundException
	 */
	@Test // Testing update delivery entity
	void testUpdateDelivery() throws RecordNotFoundException {
		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		try {
			assertEquals(obj, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws RecordNotFoundException
	 */
	@Test // Testing update delivery entity false case
	void testUpdateDeliveryWrong() throws RecordNotFoundException {
		String onwerName = "OnwerNew";
		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");

		Mockito.when(dao.save(obj)).thenReturn(obj);

		try {
			assertEquals(onwerName, service.update(obj));
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws RecordNotFoundException
	 */
	@Test // Testing delete delivery entity
	void testDeleteDelivery() throws RecordNotFoundException {
		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		Optional<DeliveryEntity> obj1 = Optional.of(new DeliveryEntity(2, "Onwer", "12:30", null, null, 0, null, null,
				Date.valueOf(LocalDate.now()), "Delivery Added"));

		Mockito.when(dao.findByDeliveryId(obj1.get().getDeliveryId())).thenReturn(obj1);
		Mockito.when(dao.deleteByDeliveryId(obj1.get().getDeliveryId())).thenReturn(obj1.get());
		try {
			DeliveryEntity src = service.delete(obj.getDeliveryId());
			assertEquals(1, src.getDeliveryId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws RecordNotFoundException
	 */
	@Test // Testing find by name
	void testFindByName() throws RecordNotFoundException {
		String name = "Onwername";
		List<DeliveryEntity> obj = new ArrayList<DeliveryEntity>();
		DeliveryEntity obj1 = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		DeliveryEntity obj2 = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		obj.add(obj1);
		obj.add(obj2);

		Mockito.when(dao.findByOwnerName(name)).thenReturn(obj);
		assertEquals(2, service.findByOwnerName(name).size());
	}

	/**
	 * @throws RecordNotFoundException
	 */
	@Test // Testing find by name false case
	void testFindByNameWrong() throws RecordNotFoundException {
		String name = "Onwername";
		List<DeliveryEntity> obj = new ArrayList<DeliveryEntity>();
		DeliveryEntity obj1 = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		DeliveryEntity obj2 = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		obj.add(obj1);
		obj.add(obj2);

		Mockito.when(dao.findByOwnerName(name)).thenReturn(obj);
		assertEquals(3, service.findByOwnerName(name).size());
	}

	/**
	 * @throws RecordNotFoundException
	 */
	@Test // Testing for find by Id
	void testFindByPk() throws RecordNotFoundException {
		Optional<DeliveryEntity> obj = Optional
				.of(new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added"));

		Mockito.when(dao.findByDeliveryId(obj.get().getDeliveryId())).thenReturn(obj);
		Optional<DeliveryEntity> obj1 = Optional.of(service.findByPk(obj.get().getDeliveryId()));
		assertEquals(obj.get().getDeliveryId(), obj1.get().getDeliveryId());

	}

	/**
	 * @throws RecordNotFoundException
	 */
	@Test // Testing for find by Id false case
	void testFindByPkWrong() throws RecordNotFoundException {
		long deliveryId = 2;
		Optional<DeliveryEntity> obj = Optional
				.of(new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added"));
		try {

			Mockito.when(dao.findByDeliveryId(obj.get().getDeliveryId())).thenReturn(obj);
			Optional<DeliveryEntity> obj1 = Optional.of(service.findByPk(obj.get().getDeliveryId()));
			assertEquals(deliveryId, obj1.get().getDeliveryId());
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws DatabaseException
	 */
	@Test // Testing for findAll
	void testSearch() throws DatabaseException {
		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		DeliveryEntity obj1 = new DeliveryEntity(2, "Onwer1", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");

		List<DeliveryEntity> list1 = new ArrayList<DeliveryEntity>();
		list1.add(obj);
		list1.add(obj1);

		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2, service.search().size());
	}

	/**
	 * @throws DatabaseException
	 */
	@Test // Testing for findAll false case
	void testSearchWrong() throws DatabaseException {
		DeliveryEntity obj = new DeliveryEntity(1, "Onwer", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");
		DeliveryEntity obj1 = new DeliveryEntity(2, "Onwer1", "12:30", Date.valueOf(LocalDate.now()), "Delivery Added");

		List<DeliveryEntity> list1 = new ArrayList<DeliveryEntity>();
		list1.add(obj);
		list1.add(obj1);

		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(3, service.search().size());
	}

}