/**
 * 
 */
package com.cg.aps.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.entities.SecurityEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.SecurityService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Administrator
 *
 */
@RestController
@Controller
@RequestMapping("/security")
public class SecurityController {

	
	@Autowired
	SecurityService service;
	
	@ApiOperation(value="Add Security",
			response = SecurityEntity.class,
			tags = "add-security",
			httpMethod = "POST")
	@PostMapping("/addSecurity")
	public ResponseEntity<SecurityEntity> addSecurity(@RequestBody SecurityEntity scr) throws DuplicateRecordException
	{
		try {
		SecurityEntity addSecurity =  service.add(scr);
		 return new ResponseEntity<SecurityEntity>(addSecurity, HttpStatus.OK);
		}
		catch(DuplicateRecordException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value="Update Security",
			response = SecurityEntity.class,
			tags = "update-security",
			httpMethod = "PUT"
			)
	@PutMapping("/updateGuard")
	public  ResponseEntity<SecurityEntity> updateSecurity(@RequestBody SecurityEntity scr) throws RecordNotFoundException
	{
		try {
		SecurityEntity updateSecurity = service.update(scr);
		return new ResponseEntity<SecurityEntity>(updateSecurity, HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@ApiOperation(value="Delete Security",
			response = String.class,
			tags = "delete-security",
			httpMethod = "DELETE")
	@DeleteMapping("/deleteSecurity/{id}")
	public ResponseEntity<String> deleteSecurity(@PathVariable("id") long id) throws RecordNotFoundException
	{
		try {
		service.delete(id);
		return new ResponseEntity<>("delete successful", HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	

	
	@ApiOperation(value="Get Security Details by alertId",
			response = SecurityEntity.class,
			tags = "get-security-details-byId",
			httpMethod = "GET")
	@GetMapping("/getById/{id}")
	 ResponseEntity<Optional<SecurityEntity>> getByPk(@PathVariable("id") String  id) throws RecordNotFoundException
	 {
		try {
		Optional<SecurityEntity> getByid = Optional.of(service.findByPk(id));
		  return new ResponseEntity<Optional<SecurityEntity>>(getByid, HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	 }
	
	@ApiOperation(value="Get All Security Details",
			response = SecurityEntity.class,
			tags = "get-all-security-details",
			httpMethod = "GET")
	@GetMapping("/getAll")
	ResponseEntity<List<SecurityEntity>> searchSecurity() throws DatabaseException
	{
		try {
		List<SecurityEntity> getAllSecurity =  service.search();
		  return new ResponseEntity<List<SecurityEntity>>(getAllSecurity, HttpStatus.OK);
		}
		catch(DatabaseException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
}
