
/**
 * @author AMBARISH DATAR
 *
 */
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
import org.springframework.web.bind.annotation.RestController;

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.service.VisitorService;

import io.swagger.annotations.ApiOperation;

@RestController
@Controller
public class VisitorController {
	
	@Autowired
	VisitorService service;
	
	@ApiOperation(value="Add Visitor here")
	@PostMapping("/addVisitor")
	private void addVisitor(@RequestBody VisitorEntity visitor) {
		// TODO Auto-generated method stub
		service.add(visitor);
	}
	
	@ApiOperation(value="Update Visitor here")
	@PutMapping("/updateVisitor")
	private void updateVisitor(@RequestBody VisitorEntity visitor) {
		// TODO Auto-generated method stub
		service.update(visitor);
	}
	
	@ApiOperation(value="Delete Visitor")
	@DeleteMapping("/deleteVisitor")
	private void deleteVisitor(@RequestBody VisitorEntity visitor) {
		// TODO Auto-generated method stub
		service.delete(visitor);
	}
	
	@ApiOperation(value="Get Visitor by name")
	@GetMapping("/getName/{name}")
	List<VisitorEntity> getByName(@PathVariable("name") String name){
		return service.findByName(name);
	}
	
	@ApiOperation(value="Get Visitor y id")
	@GetMapping("/getId/{id}")
	Optional<VisitorEntity> getByPk(@PathVariable("id") long id){
		return service.findByPk(id);
	}

	@ApiOperation(value="Get all Visitors by number of characters")
	@GetMapping("/getAll")
	List<VisitorEntity> searchVisitors(){
		return service.search();
	}
	
}
