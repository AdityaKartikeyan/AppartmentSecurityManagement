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

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.FlatRentServiceInt;

import io.swagger.annotations.ApiOperation;


	
	@RestController
	@Controller
	@RequestMapping("/FlatRent")
	public class FlatRentController {

		@Autowired
		FlatRentServiceInt service;
		
		@ApiOperation(value="Add Flat Rent",
				response = FlatRentEntity.class,
				tags = "add-flat rent",
				httpMethod = "POST")
		@PostMapping("/addFlatrent")
		public ResponseEntity<FlatRentEntity> addFlatRent(@RequestBody FlatRentEntity FlatRent) throws DuplicateRecordException
		{
			try {
				 FlatRentEntity addFlatRent =  service.add(FlatRent);
				 return new ResponseEntity<FlatRentEntity>(addFlatRent, HttpStatus.OK);
				}
				catch(DuplicateRecordException e)
				{
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
				}
		}
		
		@ApiOperation(value="Update Flat Rent",
				response = FlatRentEntity.class,
				tags = "update-flat rent",
				httpMethod = "PUT")
		@PutMapping("/updateFlatRent")
		
		public ResponseEntity<FlatRentEntity> updateFlatRent(@RequestBody FlatRentEntity flatrent) throws RecordNotFoundException
		{
			try {
			FlatRentEntity updateflatrent =  service.update(flatrent);
			 return new ResponseEntity<FlatRentEntity>(updateflatrent, HttpStatus.OK);
			}
			catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		}
		
		@ApiOperation(value="Delete Flat Rent",
				response = String.class,
				tags = "delete-flatrent",
				httpMethod = "DELETE")
		@DeleteMapping("/deleteFlatRent/{id}")
		public ResponseEntity<String> deleteFlatRent(@PathVariable("id") long id) throws RecordNotFoundException
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
		
		@ApiOperation(value="Get Flat Rent",
				response = FlatRentEntity.class,
				tags = "get-flat-Ownername",
				httpMethod = "GET")
		@GetMapping("/getOwnerName/{name}")
		ResponseEntity<FlatRentEntity> getByOwnerName(@PathVariable("name") String name) throws RecordNotFoundException
		{
			try {
			FlatRentEntity getOwnerName =  service.findByName(name);
			 return new ResponseEntity<FlatRentEntity>(getOwnerName, HttpStatus.OK);
			}catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
			
		}
		
		@ApiOperation(value="Get FlatRent Details by Id",
				response = FlatRentEntity.class,
				tags = "get-flatrent-id",
				httpMethod = "GET")
		@GetMapping("/getById/{id}")
		ResponseEntity<FlatRentEntity> getByPk(@PathVariable("id") String id) throws RecordNotFoundException
		 {
			try {
			FlatRentEntity getByid = service.findByPk(id);
			  return new ResponseEntity<FlatRentEntity>(getByid, HttpStatus.OK);
			}catch(RecordNotFoundException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		 }
		
		@ApiOperation(value="Get All FlatRent",response = FlatRentEntity.class,
				tags = "get-all-flatrent",
				httpMethod = "GET"
				)
		@GetMapping("/getAll")
		ResponseEntity<List<FlatRentEntity>> searchFlatrent() throws DatabaseException
		{
			try {
			List<FlatRentEntity> getAllFlatrent =  service.search();
			  return new ResponseEntity<List<FlatRentEntity>>(getAllFlatrent, HttpStatus.OK);
			}
			catch(DatabaseException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
			
		}
	}