
/**
 * @author AMBARISH DATAR
 *
 */
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.aps.entities.VisitorEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.VisitorService;

import io.swagger.annotations.ApiOperation;

@RestController
@Controller
public class VisitorController {
	
	@Autowired
	VisitorService service;
	
	@ApiOperation(value="Add Visitor Salary",
			response = VisitorEntity.class,
			tags = "add-Visitor slary",
			httpMethod = "POST")
	@PostMapping("/addVisitor")
	public ResponseEntity<VisitorEntity> addVisitorSalary(@RequestBody VisitorEntity visitor) throws DuplicateRecordException
	{
		try {
			VisitorEntity addVisitor =  service.add(visitor);
			 return new ResponseEntity<VisitorEntity>(addVisitor, HttpStatus.OK);
			}
			catch(DuplicateRecordException e)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
	}
	
	@ApiOperation(value="Update Visitor Salary",
			response = VisitorEntity.class,
			tags = "update-Visitor salary",
			httpMethod = "PUT")
	@PutMapping("/updateVisitor")
	
	public ResponseEntity<VisitorEntity> updateVisitorTraining(@RequestBody VisitorEntity visitor) throws RecordNotFoundException
	{
		try {
		VisitorEntity updateVisitor =  service.update(visitor);
		 return new ResponseEntity<VisitorEntity>(updateVisitor, HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@ApiOperation(value="Delete Visitor Salary",
			response = String.class,
			tags = "delete-Visitor",
			httpMethod = "DELETE")
	@DeleteMapping("/deleteVisitor/{id}")
	public ResponseEntity<String> deleteVisitorTraining(@PathVariable("id") long id) throws RecordNotFoundException
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
	
	@ApiOperation(value="Get Visitor Name",
			response = VisitorEntity.class,
			tags = "get-Visitor-name",
			httpMethod = "GET")
	@GetMapping("/getName/{name}")
	public ResponseEntity<VisitorEntity> getByName(@PathVariable("name") String name) throws RecordNotFoundException
	{
		try {
		VisitorEntity getVisitorName =  service.findByName(name);
		 return new ResponseEntity<VisitorEntity>(getVisitorName, HttpStatus.OK);
		}catch(RecordNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
		
	}
	
	@ApiOperation(value="Get Visitor Details by Id",
			response = VisitorEntity.class,
			tags = "get-Visitor-id",
			httpMethod = "GET")
	@GetMapping("/getById/{id}")
	public ResponseEntity<VisitorEntity> getByPk(@PathVariable("id") String id) throws RecordNotFoundException
	 {
		try {
		VisitorEntity getByid = service.findByPk(id);
		  return new ResponseEntity<VisitorEntity>(getByid, HttpStatus.OK);
		}catch(RecordNotFoundException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	 }
	
	@ApiOperation(value="Get All Visitors",response = VisitorEntity.class,
			tags = "get-all-Visitors",
			httpMethod = "GET"
			)
	@GetMapping("/getAll")
	public ResponseEntity<List<VisitorEntity>> searchVisitors() throws DatabaseException
	{
		try {
		List<VisitorEntity> getAllVisitors =  service.search();
		  return new ResponseEntity<List<VisitorEntity>>(getAllVisitors, HttpStatus.OK);
		}
		catch(DatabaseException e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
}