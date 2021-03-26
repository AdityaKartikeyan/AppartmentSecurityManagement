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

import com.cg.aps.entities.FlatRentEntity;
import com.cg.aps.service.FlatRentServiceInt;

import io.swagger.annotations.ApiOperation;


	
	@RestController
	@Controller
	@RequestMapping("/FlatRent")
	public class FlatRentController {

		@Autowired
		FlatRentServiceInt service;
		
		@ApiOperation(value="Add FlatRent")
		@PostMapping("/addFlatRent")
		public void addFlatRent(@RequestBody FlatRentEntity guard)
		{
			service.add(guard);
		}
		
		@ApiOperation(value="Add FlatRent")
		@PutMapping("/updateFlatRent")
		public void updateFlatRent(@RequestBody FlatRentEntity guard)
		{
			service.update(guard);
		}
		
		@ApiOperation(value="Add FlatRent")
		@DeleteMapping("/deleteFlatRent/{flatno}")
		public void deleteFlatRent(@PathVariable("flatno") String id)
		{
			service.delete(id);
		}
		
		@ApiOperation(value="Add FlatRent")
		@GetMapping("/getName/{name}")
		List<FlatRentEntity> getByName(@PathVariable("name") String name)
		{
			
			return service.findByName(name);
		}
		
		@ApiOperation(value="Add FlatRent")
		@GetMapping("/getById/{id}")
		 Optional<FlatRentEntity> getByPk(@PathVariable("id") String id)
		 {
			return service.findByPk(id);
		 }
		
		@ApiOperation(value="Add FlatRent")
		@GetMapping("/getAll")
		List<FlatRentEntity> searchGuards()
		{
			return service.search();
		}
	}
