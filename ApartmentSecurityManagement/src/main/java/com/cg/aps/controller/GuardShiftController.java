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

import com.cg.aps.entities.GuardShiftEntity;
import com.cg.aps.service.GuardShiftService;

import io.swagger.annotations.ApiOperation;

@RestController
@Controller
@RequestMapping
public class GuardShiftController 
{
	@Autowired
	GuardShiftService service;
	
	
	@ApiOperation(value="Add Guard Shift")
	@PostMapping("/addGuard")
	public void addGuardShift(@RequestBody GuardShiftEntity guard)
	{
		service.add(guard);
	}
	@ApiOperation(value="Add Guard Shift")
	@PutMapping("/updateGuard")
	public void uupdateGuardTraining(@RequestBody GuardShiftEntity guard)
	{
		service.update(guard);
	
	}
	@ApiOperation(value="Add Guard Shift")
	@DeleteMapping("/deleteGuard/{id}")
	public void deleteGuardTraining( @PathVariable("id") long id)
	{
		service.delete(id);
	}
	@ApiOperation(value="Add Guard Shift")
	@GetMapping("/getName/{name}")
	List<GuardShiftEntity> getByName(@PathVariable("name") String name)
	{
		return service.findByName(name);
	}
	@ApiOperation(value="Add Guard Shift")
	@GetMapping("/getById/{id}")
	Optional<GuardShiftEntity> getByPk(@PathVariable("id") long id)
	{
		return service.findByPk(id);	
	}
	@ApiOperation(value="Add Guard Shift")
	@GetMapping("/getAll")
	List<GuardShiftEntity> searchGuards()
	{
		return service.search();
	}
	
	
	}

	

	

