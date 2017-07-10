package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.tub.ise.anwsys.models.SmartMeter;
import de.tub.ise.anwsys.repos.SmartMeterRepository;

public class SmartMeterController {

	// springs injection annotation
	@Autowired
	private SmartMeterRepository repository;
			
	@RequestMapping(method=RequestMethod.GET)
	public List<SmartMeter> getAllProducts() {
		return repository.findAll();
	}
			
	//Path gets build with the initial RestController value and any value in the Mapping annotations
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public SmartMeter getSingleProduct(@PathVariable Long id) {
		return repository.findById(id).get();
	}
			
	//PutMapping is an alias for the following:
	//@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@PutMapping("/{id}")
	public SmartMeter update(@PathVariable Long id, @RequestBody SmartMeter input) {
		SmartMeter s = repository.findById(id).get();
		return repository.save(s);
	}
}
