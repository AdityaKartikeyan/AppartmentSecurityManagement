/**
 * 
 */
package com.cg.aps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.aps.entities.DeliveryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.DeliveryService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Vishal Rana
 *
 */
@Controller
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired
	DeliveryService service;

	/**
	 * @param Delivery
	 * @return
	 * @throws DuplicateRecordException
	 */
	@ApiOperation(value = "Add delivery", response = DeliveryEntity.class, tags = "add-Delivery", httpMethod = "POST")
	@PostMapping("/addDelivery")
	public ResponseEntity<DeliveryEntity> addDelivery(@RequestBody DeliveryEntity delivery)
			throws DuplicateRecordException {
		try {
			DeliveryEntity addDelivery = service.add(delivery);
			return new ResponseEntity<DeliveryEntity>(addDelivery, HttpStatus.OK);
		} catch (DuplicateRecordException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/**
	 * @param delivery
	 * @return
	 * @throws RecordNotFoundException
	 */
	@ApiOperation(value = "Update delivery", response = DeliveryEntity.class, tags = "update-Delivery", httpMethod = "PUT")
	@PutMapping("/updateDelivery")

	public ResponseEntity<DeliveryEntity> updateDeliveryEntity(@RequestBody DeliveryEntity delivery)
			throws RecordNotFoundException {
		try {
			DeliveryEntity updateDelivery = service.update(delivery);
			return new ResponseEntity<DeliveryEntity>(updateDelivery, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	/**
	 * @param deliveryId
	 * @return
	 * @throws RecordNotFoundException
	 */
	@ApiOperation(value = "Delete delivery details by deliveryId", response = String.class, tags = "delete-Delivery", httpMethod = "DELETE")
	@DeleteMapping("/deleteDelivery/{deliveryId}")
	public ResponseEntity<String> deleteGuardTraining(@PathVariable("deliveryId") long deliveryId)
			throws RecordNotFoundException {
		try {
			service.delete(deliveryId);
			return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/**
	 * @param onwerName
	 * @return
	 * @throws RecordNotFoundException
	 */
	@ApiOperation(value = "Get delivery using onwerName", response = DeliveryEntity.class, tags = "get-Delivery-Using-OnwerName", httpMethod = "GET")
	@GetMapping("/getName/{onwerName}")
	public ResponseEntity<List<DeliveryEntity>> getByOnwerName(@PathVariable("onwerName") String onwerName)
			throws RecordNotFoundException {
		try {
			List<DeliveryEntity> getOwnerName = service.findByOwnerName(onwerName);
			// return new ResponseEntity<List<DeliveryEntity>>(HttpStatus.OK);
			return new ResponseEntity<List<DeliveryEntity>>(getOwnerName, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	/**
	 * @param deliveryId
	 * @return
	 * @throws RecordNotFoundException
	 */
	@ApiOperation(value = "Get delivery details by deliveryId", response = DeliveryEntity.class, tags = "get-Delivery-Using-DeliveryId", httpMethod = "GET")
	@GetMapping("/getByPk/{deliveryId}")
	public ResponseEntity<DeliveryEntity> getByPk(@PathVariable("deliveryId") long deliveryId)
			throws RecordNotFoundException {
		try {
			DeliveryEntity getByDeliveryId = service.findByPk(deliveryId);
			return new ResponseEntity<DeliveryEntity>(getByDeliveryId, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	/**
	 * @return
	 * @throws DatabaseException
	 */
	@ApiOperation(value = "Get all deliveries", response = DeliveryEntity.class, tags = "get-All-Deliveries", httpMethod = "GET")
	@GetMapping("/getAll")
	public ResponseEntity<List<DeliveryEntity>> searchDeliveries() throws DatabaseException {
		try {
			List<DeliveryEntity> getAllDeliveries = service.search();
			return new ResponseEntity<List<DeliveryEntity>>(getAllDeliveries, HttpStatus.OK);
		} catch (DatabaseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}
	// http://localhost:5050/swagger-ui.html
}
