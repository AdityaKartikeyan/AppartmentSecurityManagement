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

import com.cg.aps.entities.GuardSalaryEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.GuardSalaryService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Aravind
 *
 */

@RestController
@Controller
@RequestMapping("/guard")
public class GuardSalaryController {

	@Autowired
	GuardSalaryService service;

	@ApiOperation(value = "Add Guard Salary", // Controller operation to Add Guard Salary
			response = GuardSalaryEntity.class, tags = "add-guard", httpMethod = "POST")
	@PostMapping("/addGuard")
	public ResponseEntity<GuardSalaryEntity> addGuardTraining(@RequestBody GuardSalaryEntity guard)
			throws DuplicateRecordException {

		GuardSalaryEntity addGuard = service.add(guard);
		return new ResponseEntity<GuardSalaryEntity>(addGuard, HttpStatus.OK);

	}

	@ApiOperation(value = "Update Guard Salary", // Controller operation to Update Guard Salary
			response = GuardSalaryEntity.class, tags = "update-guard", httpMethod = "PUT")
	@PutMapping("/updateGuard")

	public ResponseEntity<GuardSalaryEntity> updateGuardTraining(@RequestBody GuardSalaryEntity guard)
			throws RecordNotFoundException {

		GuardSalaryEntity updateGuard = service.update(guard);
		return new ResponseEntity<GuardSalaryEntity>(updateGuard, HttpStatus.OK);

	}

	@ApiOperation(value = "Delete Guard Salary", // Controller operation to Delete Guard Salary
			response = String.class, tags = "delete-guard", httpMethod = "DELETE")
	@DeleteMapping("/deleteGuard/{id}")
	public ResponseEntity<String> deleteGuardTraining(@PathVariable("id") long id) throws RecordNotFoundException {

		service.delete(id);
		return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);

	}

	@ApiOperation(value = "Get Guard Name", // Controller operation to get Guard Details by Name
			response = GuardSalaryEntity.class, tags = "get-guard-name", httpMethod = "GET")
	@GetMapping("/getName/{name}")
	public ResponseEntity<GuardSalaryEntity> getByName(@PathVariable("name") String name)
			throws RecordNotFoundException {

		GuardSalaryEntity getGuardName = service.findByName(name);
		return new ResponseEntity<GuardSalaryEntity>(getGuardName, HttpStatus.OK);

	}

	@ApiOperation(value = "Get Guard Details by Id", // Controller operation to get Guard Details by Id
			response = GuardSalaryEntity.class, tags = "get-guard-id", httpMethod = "GET")
	@GetMapping("/getById/{id}")
	public ResponseEntity<GuardSalaryEntity> getByPk(@PathVariable("id") long id) throws RecordNotFoundException {

		GuardSalaryEntity getByid = service.findByPk(id);
		return new ResponseEntity<GuardSalaryEntity>(getByid, HttpStatus.OK);

	}

	@ApiOperation(value = "Get All Guards", response = GuardSalaryEntity.class, // Controller operation to get all
																				// Guards Details
			tags = "get-all-guards", httpMethod = "GET")
	@GetMapping("/getAll")
	public ResponseEntity<List<GuardSalaryEntity>> searchGuards() throws DatabaseException {

		List<GuardSalaryEntity> getAllGuards = service.search();
		return new ResponseEntity<List<GuardSalaryEntity>>(getAllGuards, HttpStatus.OK);

	}
}