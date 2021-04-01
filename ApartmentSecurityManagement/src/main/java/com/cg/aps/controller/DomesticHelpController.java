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

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.service.DomesticHelpService;

import io.swagger.annotations.ApiOperation;

@RestController
@Controller
@RequestMapping("/DomesticHelp")
public class DomesticHelpController {

	@Autowired
	DomesticHelpService service;

	@ApiOperation(value = "Add DomesticHelp Training", response = DomesticHelpEntity.class, tags = "add-domestichelp", httpMethod = "POST")
	@PostMapping("/adddomestichelp")
	public ResponseEntity<DomesticHelpEntity> addDomesticHelpTraining(@RequestBody DomesticHelpEntity domestichelp)
			throws DuplicateRecordException {

		DomesticHelpEntity adddomestichelp = service.add(domestichelp);
		return new ResponseEntity<DomesticHelpEntity>(adddomestichelp, HttpStatus.OK);  //add domestic help

	}

	@ApiOperation(value = "Update DomesticHelp Training", response = DomesticHelpEntity.class, tags = "update-domestichelp", httpMethod = "PUT")
	@PutMapping("/updateDomesticHelp")

	public ResponseEntity<DomesticHelpEntity> updateDomesticHelpTraining(
			@RequestBody DomesticHelpEntity DomesticHelp) throws RecordNotFoundException {

		DomesticHelpEntity updateDomesticHelp = service.update(DomesticHelp);
		return new ResponseEntity<DomesticHelpEntity>(updateDomesticHelp, HttpStatus.OK);      //update-domestichelp

	}

	@ApiOperation(value = "Delete DomesticHelp Training", response = String.class, tags = "delete-domestichelp", httpMethod = "DELETE")
	@DeleteMapping("/deleteDomesticHelp/{id}")
	public ResponseEntity<String> deleteDomesticHelpTraining(@PathVariable("id") long id)
			throws RecordNotFoundException {

		service.delete(id);
		return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);      //delete-domestichelp

	}

	@ApiOperation(value = "Get DomesticHelp Name", response = DomesticHelpEntity.class, tags = "get-domestichelp-name", httpMethod = "GET")
	@GetMapping("/getName/{name}")
	public ResponseEntity<DomesticHelpEntity> getByName(@PathVariable("name") String name)
			throws RecordNotFoundException {

		DomesticHelpEntity getDomesticHelpName = service.findByName(name);
		return new ResponseEntity<DomesticHelpEntity>(getDomesticHelpName, HttpStatus.OK);                //get-domestichelp-name

	}

	@ApiOperation(value = "Get DomesticHelp Details by Id", response = DomesticHelpEntity.class, tags = "get-domestichelp-id", httpMethod = "GET")
	@GetMapping("/getById/{id}")
	public ResponseEntity<DomesticHelpEntity> getByPk(@PathVariable("id") String id)
			throws RecordNotFoundException {

		DomesticHelpEntity getByid = service.findByPk(id);
		return new ResponseEntity<DomesticHelpEntity>(getByid, HttpStatus.OK);        //get-domestichelp by id

	}

	@ApiOperation(value="Get All DomesticHelps",response = DomesticHelpEntity.class,
			tags = "get-all-domestichelp",
			httpMethod = "GET"
			)
	@GetMapping("/getAll")
	public ResponseEntity<List<DomesticHelpEntity>> searchDomesticHelps() throws DatabaseException
	{
		
		List<DomesticHelpEntity> getAllDomesticHelps =  service.search();
		  return new ResponseEntity<List<DomesticHelpEntity>>(getAllDomesticHelps, HttpStatus.OK);                    //get all
		
		                                  
	}
}
