/**
 * 
 */
package com.cg.aps.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.service.DeliveryService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Vishal Rana
 *
 */
@Controller
@RestController
@RequestMapping("/Delivery")
public class DeliveryController {
	@Autowired
	DeliveryService service;

	@ApiOperation(value = "Add Delivery")
	@PostMapping("/addDelivery")
	public void addDelivery(@RequestBody DeliveryEntity Delivery) {
		service.add(Delivery);
	}

	@ApiOperation(value = "Update Delivery")
	@PutMapping("/updateDelivery")
	public void updateDelivery(@RequestBody DeliveryEntity Delivery) {
		service.update(Delivery);
	}

	@ApiOperation(value = "Delete Delivery Using Id")
	@DeleteMapping("/deleteDelivery/{deliveryId}")
	public void deleteDelivery(@PathVariable("deliveryId") long deliveryId) {
		service.delete(deliveryId);
	}

	@ApiOperation(value = "Find By OwnerName")
	@GetMapping("/getName/{name}")
	public List<DeliveryEntity> getByOwnerName(@PathVariable("name") String name) {
		return service.findByOwnerName(name);
	}

	@ApiOperation(value = "Get Delivery By Id")
	@GetMapping("/getDeliveryId/{deliveryId}")
	public Optional<DeliveryEntity> getByPk(@PathVariable("deliveryId") long deliveryId) {
		return service.findByPk(deliveryId);
	}

	@ApiOperation(value = "Get All Deliveries")
	@GetMapping("/getAll")
	public List<DeliveryEntity> searchDeliveries() {
		return service.search();
	}
	// http://localhost:5050/swagger-ui.html
	
}
