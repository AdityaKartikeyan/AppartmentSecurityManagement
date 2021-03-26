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

@RestController
@Controller
@RequestMapping


public class DomesticHelpController {
@Autowired
DomesticHelpService service;


@PostMapping("/add Guard")
public void addDomesticHelp(@RequestBody DomesticHelpEntity guard)
{
	service.add(guard);
}

@PutMapping("/updateGuard")
public void uupdateGuardTraining(@RequestBody DomesticHelpEntity guard)
{
	service.update(guard);

}

@DeleteMapping("/deleteGuard")
public void deleteGuardTraining(@RequestBody DomesticHelpEntity guard)
{
	service.delete(guard);
}

@GetMapping("/getName/{name}")
List<DomesticHelpEntity> getByName(@PathVariable("name") String name)
{
	return service.findByName(name);
}

@GetMapping("/getById/{id}")
Optional<DomesticHelpEntity> getByPk(@PathVariable("id") long id)
{
	return service.findByPk(id);	
}

@GetMapping("/getAll")
List<DomesticHelpEntity> searchGuards()
{
	return service.search();
}


}

