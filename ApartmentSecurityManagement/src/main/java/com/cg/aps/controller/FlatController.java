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

import com.cg.aps.entities.FlatEntity;
import com.cg.aps.service.FlatServiceInt;

import io.swagger.annotations.ApiOperation;


	
	@RestController
	@Controller
	@RequestMapping("/Flat")
	public class FlatController {

		@Autowired
		FlatServiceInt service;
		
		@ApiOperation(value="Add Flat")
		@PostMapping("/addFlat")
		public void addFlat(@RequestBody FlatEntity Flat)
		{
			service.add(Flat);
		}
		
		@ApiOperation(value="Add Flat")
		@PutMapping("/updateFlat")
		public void updateFlat(@RequestBody FlatEntity Flat)
		{
			service.update(Flat);
		}
		
		@ApiOperation(value="Add Flat")
		@DeleteMapping("/deleteFlat/{flatno}")
		public void deleteFlat(@PathVariable("flatno") String id)
		{
			service.delete(id);
		}
		
		@ApiOperation(value="Add Flat")
		@GetMapping("/getName/{name}")
		List<FlatEntity> getByName(@PathVariable("name") String name)
		{
			
			return service.findByName(name);
		}
		
		@ApiOperation(value="Add Flat")
		@GetMapping("/getById/{id}")
		 Optional<FlatEntity> getByPk(@PathVariable("id") String id)
		 {
			return service.findByPk(id);
		 }
		
		@ApiOperation(value="Add Flat")
		@GetMapping("/getAll")
		List<FlatEntity> searchFlats()
		{
			return service.search();
		}
	}
