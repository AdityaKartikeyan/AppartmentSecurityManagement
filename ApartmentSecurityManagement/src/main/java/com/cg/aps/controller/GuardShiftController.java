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

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.GuardShiftService;

import io.swagger.annotations.ApiOperation;

	@RestController
	@Controller
	@RequestMapping
	public class GuardShiftController 
	{
		@Autowired
		GuardShiftService service;
		
		
		@ApiOperation(value="Add Guard Shift",
				response = GuardShiftEntity.class,
				tags = "add-guard shift",
				httpMethod = "POST")
		@PostMapping("/addGuard")
		public ResponseEntity<GuardShiftEntity> addGuardShift(@RequestBody GuardShiftEntity guard) throws DuplicateRecordException
		{
			try {
				 GuardShiftEntity addGuard =  service.add(guard);
				 return new ResponseEntity<GuardShiftEntity>(addGuard, HttpStatus.OK);
				}
				catch(DuplicateRecordException e)
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
				}
		}
		
		@ApiOperation(value="Update Guard Shift",
				response = GuardShiftEntity.class,
				tags = "update-guard shift",
				httpMethod = "PUT")
		@PutMapping("/updateGuard")
		
		public ResponseEntity<GuardShiftEntity> updateGuardShift(@RequestBody GuardShiftEntity guard) throws RecordNotFoundException
		{
			try {
			GuardShiftEntity updateGuard =  service.update(guard);
			 return new ResponseEntity<GuardShiftEntity>(updateGuard, HttpStatus.OK);
			}
			catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		}
		
		@ApiOperation(value="Delete Guard Shift",
				response = String.class,
				tags = "delete-guard",
				httpMethod = "DELETE")
		@DeleteMapping("/deleteGuard/{id}")
		public ResponseEntity<String> deleteGuardShift(@PathVariable("id") long id) throws RecordNotFoundException
		{
			try {
			service.delete(id);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
			}
			catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		}
		
		@ApiOperation(value="Get Guard Shift",
				response = GuardShiftEntity.class,
				tags = "get-guard-shift",
				httpMethod = "GET")
		@GetMapping("/getName/{name}")
		ResponseEntity<GuardShiftEntity> getByName(@PathVariable("name") String name) throws RecordNotFoundException
		{
			try {
			GuardShiftEntity getGuardName =  service.findByName(name);
			 return new ResponseEntity<GuardShiftEntity>(getGuardName, HttpStatus.OK);
			}catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
			
		}
		
		@ApiOperation(value="Get Guard Details by Id",
				response = GuardShiftEntity.class,
				tags = "get-guard-id",
				httpMethod = "GET")
		@GetMapping("/getById/{id}")
		ResponseEntity<GuardShiftEntity> getByPk(@PathVariable("id") long id) throws RecordNotFoundException
		 {
			try {
			GuardShiftEntity getByid = service.findByPk(id);
			  return new ResponseEntity<GuardShiftEntity>(getByid, HttpStatus.OK);
			}catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		 }
		
		@ApiOperation(value="Get All Guards",response = GuardShiftEntity.class,
				tags = "get-all-guards",
				httpMethod = "GET"
				)
		@GetMapping("/getAll")
		ResponseEntity<List<GuardShiftEntity>> searchGuards() throws DatabaseException
		{
			try {
			List<GuardShiftEntity> getAllGuards =  service.search();
			  return new ResponseEntity<List<GuardShiftEntity>>(getAllGuards, HttpStatus.OK);
			}
			catch(DatabaseException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		}
	}
	
	
	

	

