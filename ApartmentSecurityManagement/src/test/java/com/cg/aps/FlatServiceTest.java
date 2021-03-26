package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.repository.FlatDaoInt;
import com.cg.aps.service.FlatServiceInt;

@SpringBootTest

public class FlatServiceTest {
	@MockBean
	FlatDaoInt dao;
	@Autowired
	FlatServiceInt service;

	@Test
	public void testAddFlat() {

		FlatEntity obj = new FlatEntity(101, "Sahitya", "1041", LocalDateTime.now(),
				LocalDateTime.now(), "owner", "1041b", "10", "3BHK");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));
	}

	@Test
	public void testUpdateFlat() {

		FlatEntity obj = new FlatEntity(101, "Sahitya", "1041", LocalDateTime.now(),
				LocalDateTime.now(), "owner", "1041b", "10", "3BHK");

		Mockito.when(dao.save(obj)).thenReturn(obj);

		assertEquals(obj, service.add(obj));

		obj.setFloorNo("10");
		obj.setFlatNo("1041b");

		assertEquals(obj, service.update(obj));

	}

	@Test
	public void testDeleteFlat() {
		FlatEntity obj = new FlatEntity(101, "Sahitya", "1041", LocalDateTime.now(),
				LocalDateTime.now(), "owner", "1041b", "10", "3BHK");
		service.delete(obj.getFlatNo());
		verify(dao, times(1)).deleteById(obj.getFlatNo());
	}

	@Test
	public void testFindByName() {
		String name = "Sahitya";
		FlatEntity obj = new FlatEntity(101, "Sahitya", "1041", LocalDateTime.now(),
				LocalDateTime.now(), "owner", "1041b", "10", "3BHK");
		FlatEntity obj1 = new FlatEntity(101, "mridul", "1045", LocalDateTime.now(),
				LocalDateTime.now(), "owner2", "1045", "12", "2BHK");
		List<FlatRentEntity> list = new ArrayList();

		List<FlatEntity> list1 = new ArrayList();
		list1.add(obj);
		list1.add(obj1);

		Mockito.when(dao.findByOwnerName(name)).thenReturn(list1);
		assertEquals(2, service.findByName(name).size());

	}

	@Test
	public void testFindByPk() {

		Optional<FlatEntity> obj = Optional
				.of(new FlatEntity(101, "Sahitya", "1041", LocalDateTime.now(),
						LocalDateTime.now(), "owner", "1041b", "10", "3BHK"));

		Mockito.when(dao.findById(obj.get().getFlatNo())).thenReturn(obj);
		Optional<FlatEntity> obj1 = service.findByPk(obj.get().getFlatNo());
		assertEquals(obj.get().getFlatNo(), obj1.get().getFlatNo());

	}

	@Test
	public void testSearch() {
		FlatEntity obj = new FlatEntity(101, "Sahitya", "1041", LocalDateTime.now(),
				LocalDateTime.now(), "owner", "1041b", "10", "3BHK");
		FlatEntity obj1 = new FlatEntity(101, "mridul", "1045", LocalDateTime.now(),
				LocalDateTime.now(), "owner2", "1045", "12", "2BHK");
		List<FlatEntity> list1 = new ArrayList();
		list1.add(obj);
		list1.add(obj1);

		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2, service.search().size());
	}
}
