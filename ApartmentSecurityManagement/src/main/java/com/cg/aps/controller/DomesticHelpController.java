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

import com.cg.aps.entities.DomesticHelpEntity;
import com.cg.aps.service.DomesticHelpService;

import io.swagger.annotations.ApiOperation;

@RestController
@Controller
@RequestMapping


public class DomesticHelpController {
@Autowired
DomesticHelpService service;

@ApiOperation(value="Add Domestic Help")
@PostMapping("/add Guard")
public void addDomesticHelp(@RequestBody DomesticHelpEntity guard)
{
	service.add(guard);
}
@ApiOperation(value="Add Domestic Help")
@PutMapping("/updateGuard")
public void uupdateDomesticHelp(@RequestBody DomesticHelpEntity guard)
{
	service.update(guard);

}
@ApiOperation(value="Add Domestic Help")
@DeleteMapping("/deleteGuard/{id}")
public void deleteDomesticHelp(@PathVariable("id") long id )
{
	service.delete(id);
}
@ApiOperation(value="Add Domestic Help")
@GetMapping("/getName/{name}")
List<DomesticHelpEntity> getByName(@PathVariable("name") String name)
{
	return service.findByName(name);
}
@ApiOperation(value="Add Domestic Help")
@GetMapping("/getById/{id}")
Optional<DomesticHelpEntity> getByPk(@PathVariable("id") long id)
{
	return service.findByPk(id);	
}
@ApiOperation(value="Add Domestic Help")
@GetMapping("/getAll")
List<DomesticHelpEntity> searchGuards()
{
	return service.search();
}


}

