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

import com.cg.aps.entities.VehicleEntity;
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

	@ApiOperation(value="Add Vehicle")
	@PostMapping("/addVehicle")
	public void addVehicle(@RequestBody VehicleEntity vehicle) {
		service.add(vehicle);
	}

	@ApiOperation(value="Update Vehicle")
	@PutMapping("/updatevehicle")
	public void updateVehicle(@RequestBody VehicleEntity vehicle) {
		service.update(vehicle);
	}

	@ApiOperation(value="Delete Vehicle")
	@DeleteMapping("/deletevehicle/{id}")
	public void deleteVehicle(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	@ApiOperation(value="Get Vehicle Name")
	@GetMapping("/getName/{name}")
	List<VehicleEntity> getByName(@PathVariable("name") String name) {
		return service.findByName(name);
	}

	@ApiOperation(value="Get Vehicle Details By ID")
	@GetMapping("/getById/{id}")
	Optional<VehicleEntity> getByPk(@PathVariable("id") String id) {
		return service.findByPk(id);
	}

	@ApiOperation(value="Get all Vehicles")
	@GetMapping("/getAll")
	List<VehicleEntity> searchVehicles() {
		return service.search();
	}
}
