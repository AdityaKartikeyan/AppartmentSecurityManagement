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

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.FlatServiceInt;

import io.swagger.annotations.ApiOperation;


	
	@RestController
	@Controller
	@RequestMapping("/Flat")
	public class FlatController {

		@Autowired
		FlatServiceInt service;
		@ApiOperation(value="Add Flat",
				response = FlatEntity.class,
				tags = "add-flat",
				httpMethod = "POST")
		@PostMapping("/addFlat")
		public ResponseEntity<FlatEntity> addFlat(@RequestBody FlatEntity flat) throws DuplicateRecordException
		{
			try {
				 FlatEntity addFlat =  service.add(flat);
				 return new ResponseEntity<FlatEntity>(addFlat, HttpStatus.OK);
				}
				catch(DuplicateRecordException e)
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
				}
		}
		
		@ApiOperation(value="Update Flat",
				response = FlatEntity.class,
				tags = "update-Flat",
				httpMethod = "PUT")
		@PutMapping("/updateFlat")
		
		public ResponseEntity<FlatEntity> updateFlat(@RequestBody FlatEntity Flat) throws RecordNotFoundException
		{
			try {
			FlatEntity updateFlat =  service.update(Flat);
			 return new ResponseEntity<FlatEntity>(updateFlat, HttpStatus.OK);
			}
			catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		}
		
		@ApiOperation(value="Delete Flat",
				response = String.class,
				tags = "delete-Flat",
				httpMethod = "DELETE")
		@DeleteMapping("/deleteFlat/{id}")
		public ResponseEntity<String> deleteFlat(@PathVariable("id") long id) throws RecordNotFoundException
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
		
		@ApiOperation(value="Get Flat",
				response = FlatEntity.class,
				tags = "get-Flat-OwnerName",
				httpMethod = "GET")
		@GetMapping("/getName/{name}")
		ResponseEntity<FlatEntity> getByName(@PathVariable("name") String name) throws RecordNotFoundException
		{
			try {
			FlatEntity getFlatOwnerName =  service.findByName(name);
			 return new ResponseEntity<FlatEntity>(getFlatOwnerName, HttpStatus.OK);
			}catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
			
		}
		
		@ApiOperation(value="Get Flat by Id",
				response = FlatEntity.class,
				tags = "get-Flat-id",
				httpMethod = "GET")
		@GetMapping("/getById/{id}")
		ResponseEntity<FlatEntity> getByPk(@PathVariable("id") String id) throws RecordNotFoundException
		 {
			try {
			FlatEntity getByid = service.findByPk(id);
			  return new ResponseEntity<FlatEntity>(getByid, HttpStatus.OK);
			}catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		 }
		
		@ApiOperation(value="Get All Flat",response = FlatEntity.class,
				tags = "get-all-flat",
				httpMethod = "GET"
				)
		@GetMapping("/getAll")
		ResponseEntity<List<FlatEntity>> searchFlats() throws DatabaseException
		{
			try {
			List<FlatEntity> getAllFLats =  service.search();
			  return new ResponseEntity<List<FlatEntity>>(getAllFLats, HttpStatus.OK);
			}
			catch(DatabaseException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		}
	}