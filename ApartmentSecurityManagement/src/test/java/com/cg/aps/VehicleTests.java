package com.cg.aps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.aps.entities.VehicleEntity;
import com.cg.aps.repository.VehicleDao;
import com.cg.aps.service.VehicleService;

@SpringBootTest
class VehicleTests {

	/**
	 * @author Anshul Joshi
	 */
	@MockBean
	VehicleDao dao;
	@Autowired
	VehicleService service;

	@Test
	public void testAddVehicle() {

		VehicleEntity obj = new VehicleEntity(1222, "Anshul", "Joshi", LocalDateTime.now(),
				LocalDateTime.now(), "AJ", "101", "11:30", "12:30", Date.valueOf(LocalDate.now()),
				"103", "Honda City");

		Mockito.when(dao.save(obj)).thenReturn(obj);
		assertEquals(obj, service.add(obj));

	} // testing update vehicle entity

	@Test
	public void testVehicle() {

		VehicleEntity obj = new VehicleEntity(1222, "Anshul", "Joshi", LocalDateTime.now(),
				LocalDateTime.now(), "AJ", "101", "11:30", "12:30", Date.valueOf(LocalDate.now()),
				"103", "Honda City");

		Mockito.when(dao.save(obj)).thenReturn(obj);

		assertEquals(obj, service.add(obj));

		obj.setName("Joshi");
		obj.setArrivalTime("10:30");
//		obj.setStatus("working");

		assertEquals(obj, service.update(obj));

	}

	// testing delete vehicle entity

	@Test
	public void testvehicle() {
		VehicleEntity obj = new VehicleEntity(1222, "Anshul", "Joshi", LocalDateTime.now(),
				LocalDateTime.now(), "AJ", "101", "11:30", "12:30", Date.valueOf(LocalDate.now()),
				"103", "Honda City");
		service.delete(obj.getVehicleNo());
		verify(dao, times(1)).deleteById(obj.getVehicleNo());
	}

	// testing find by name

	@Test
	public void testFindByName() {
		String name = "Anshul";
		VehicleEntity obj = new VehicleEntity(1222, "Anshul", "Joshi", LocalDateTime.now(),
				LocalDateTime.now(), "AJ", "101", "11:30", "12:30", Date.valueOf(LocalDate.now()),
				"103", "Honda City");
		VehicleEntity obj1 = new VehicleEntity(1222, "Joshi", "Anshul", LocalDateTime.now(),
				LocalDateTime.now(), "Anshul", "103", "10:30", "1:30",
				Date.valueOf(LocalDate.now()), "104", "Honda Jazz");

		List<VehicleEntity> list = new ArrayList();
		list.add(obj);
		list.add(obj1);

		Mockito.when(dao.findByName(name)).thenReturn(list);
		assertEquals(2, service.findByName(name).size());

	}

	// testing for find by ID
	@Test
	public void testFindByPk() {

		Optional<VehicleEntity> obj = Optional.of(new VehicleEntity(1222, "Anshul", "Joshi",
				LocalDateTime.now(), LocalDateTime.now(), "AJ", "101",
				"11:30", "12:30", Date.valueOf(LocalDate.now()), "103", "Honda Fit"));

		Mockito.when(dao.findById(obj.get().getVehicleNo())).thenReturn(obj);
		Optional<VehicleEntity> obj1 = service.findByPk(obj.get().getVehicleNo());
		assertEquals(obj.get().getVehicleNo(), obj1.get().getVehicleNo());

	}

	// SEARCHING

	@Test
	public void testSearch() {
		VehicleEntity obj = new VehicleEntity(777, "Anshul", "Joshi", LocalDateTime.now(),
				LocalDateTime.now(), "AJ", "104", "1:30", "4:30", Date.valueOf(LocalDate.now()),
				"108", "Honda Fit");
		VehicleEntity obj1 = new VehicleEntity(799, "Aditya", "Aravind", LocalDateTime.now(),
				LocalDateTime.now(), "AJ", "109", "2:30", "7:30", Date.valueOf(LocalDate.now()),
				"110", "Honda Jazz");
		List<VehicleEntity> list1 = new ArrayList();
		list1.add(obj);
		list1.add(obj1);

		Mockito.when(dao.findAll()).thenReturn(list1);
		assertEquals(2, service.search().size());
	}

}
