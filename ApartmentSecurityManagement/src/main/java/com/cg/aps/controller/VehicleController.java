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

import com.cg.aps.entities.VehicleEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.VehicleService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Anshul Joshi
 *
 */

@RestController
@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehicleService service;

	@ApiOperation(value = "Add Vehicle", response = VehicleEntity.class, tags = "add-Vehicle", httpMethod = "POST")
	@PostMapping("/addVehicle")
	public ResponseEntity<VehicleEntity> addVehicle(@RequestBody VehicleEntity vehicle)
			throws DuplicateRecordException {
		try {
			VehicleEntity addVehicle = service.add(vehicle);
			return new ResponseEntity<VehicleEntity>(addVehicle, HttpStatus.OK);
		} catch (DuplicateRecordException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@ApiOperation(value = "Update Vehicle", response = VehicleEntity.class, tags = "update-vehicle", httpMethod = "PUT")
	@PutMapping("/updateVehicle")

	public ResponseEntity<VehicleEntity> updateVehicle(@RequestBody VehicleEntity vehicle)
			throws RecordNotFoundException {
		try {
			VehicleEntity updateVehicle = service.update(vehicle);
			return new ResponseEntity<VehicleEntity>(updateVehicle, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@ApiOperation(value = "Delete Vehicle", response = String.class, tags = "delete-vehicle", httpMethod = "DELETE")
	@DeleteMapping("/deleteVehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") long id) throws RecordNotFoundException {
		try {
			service.delete(id);
			return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@ApiOperation(value = "Get Vehicle", response = VehicleEntity.class, tags = "get-vehicle", httpMethod = "GET")
	@GetMapping("/getName/{name}")
	ResponseEntity<VehicleEntity> getByName(@PathVariable("name") String name) throws RecordNotFoundException {
		try {
			VehicleEntity getVehicle = service.findByName(name);
			return new ResponseEntity<VehicleEntity>(getVehicle, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@ApiOperation(value = "Get Vehicle by Id", response = VehicleEntity.class, tags = "get-vehicle", httpMethod = "GET")
	@GetMapping("/getById/{id}")
	ResponseEntity<VehicleEntity> getByPk(@PathVariable("id") String id) throws RecordNotFoundException {
		try {
			VehicleEntity getByid = service.findByPk(id);
			return new ResponseEntity<VehicleEntity>(getByid, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@ApiOperation(value = "Get All Vehicles", response = VehicleEntity.class, tags = "get-all-vehicle", httpMethod = "GET")
	@GetMapping("/getAll")
	ResponseEntity<List<VehicleEntity>> searchVehicle() throws DatabaseException {
		try {
			List<VehicleEntity> getAllVehicle = service.search();
			return new ResponseEntity<List<VehicleEntity>>(getAllVehicle, HttpStatus.OK);
		} catch (DatabaseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}
}
