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

import com.cg.aps.entities.GuardTrainingEntity;
import com.cg.aps.service.GuardTrainingService;

import io.swagger.annotations.ApiOperation;

@RestController
@Controller
@RequestMapping("/guard")
public class GuardTrainingController {

	@Autowired
	GuardTrainingService service;
	
	@ApiOperation(value="Add Guard Training")
	@PostMapping("/addGuard")
	public void addGuardTraining(@RequestBody GuardTrainingEntity guard)
	{
		service.add(guard);
	}
	
	@ApiOperation(value="Update Guard Training")
	@PutMapping("/updateGuard")
	public void updateGuardTraining(@RequestBody GuardTrainingEntity guard)
	{
		service.update(guard);
	}
	
	@ApiOperation(value="Delete Guard Training")
	@DeleteMapping("/deleteGuard/{id}")
	public void deleteGuardTraining(@PathVariable("id") long id)
	{
		service.delete(id);
	}
	
	@ApiOperation(value="Get Guard Name")
	@GetMapping("/getName/{name}")
	List<GuardTrainingEntity> getByName(@PathVariable("name") String name)
	{
		
		return service.findByName(name);
	}
	
	@ApiOperation(value="Get Guard Details by Id")
	@GetMapping("/getById/{id}")
	 Optional<GuardTrainingEntity> getByPk(@PathVariable("id") long id)
	 {
		return service.findByPk(id);
	 }
	
	@ApiOperation(value="Get All Guards")
	@GetMapping("/getAll")
	List<GuardTrainingEntity> searchGuards()
	{
		return service.search();
	}
	
}
