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

import com.cg.aps.entities.GuardSalaryEntity;
import com.cg.aps.service.GuardSalaryService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Aravind
 *
 */
@RestController
@Controller
@RequestMapping
public class GuardSalaryController {
	@Autowired
	GuardSalaryService service;
	
	@ApiOperation(value="Add Guard Salary")
	@PostMapping("/addGuard")
	public void addGuardSalary(@RequestBody GuardSalaryEntity guard)
	{
		service.add(guard);
	}
	
	@ApiOperation(value="Update Guard Salary")
	@PutMapping("/updateGuard")
	public void updateGuardSalary(@RequestBody GuardSalaryEntity guard)
	{
		service.update(guard);
	}
	@ApiOperation(value="Delete Guard Salary")
	@DeleteMapping("/deleteGuard/{id}")
	public void deleteGuardSalary(@PathVariable("id")long id)
	{
		service.delete(id);
	}
	
	@ApiOperation(value="Get Guard Name")
	@GetMapping("/getName/{name}")
	List<GuardSalaryEntity> getByName(@PathVariable String name)
	{
		return service.findByName(name);
	}
	@ApiOperation(value="Get Guard Id")
	@GetMapping("/getbyId/{id}")
	Optional<GuardSalaryEntity>getbyPk(@PathVariable("id")long id)
	{
		return service.findByPk(id);
	}
	@ApiOperation(value="Get all")
	@GetMapping("/getAll")
	List<GuardSalaryEntity> searchGuards()
	{
		return service.search();
		}
}
