package de.tub.ise.anwsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.tub.ise.anwsys.models.Messdaten;
import de.tub.ise.anwsys.repos.MessdatenRepository;

public class MessdatenController {

	// springs injection annotation
	@Autowired
	private MessdatenRepository repository;
	
	//@PostMapping
	@RequestMapping(method=RequestMethod.POST)
	public Messdaten createProduct(@RequestBody Messdaten input) {
		Messdaten m = new Messdaten(input.getTimestamp(), input.getMesswert());
		return repository.save(m);
	}
		
	@RequestMapping(method=RequestMethod.GET)
	public List<Messdaten> getAllProducts() {
		return repository.findAll();
	}
		
	//Path gets build with the initial RestController value and any value in the Mapping annotations
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Messdaten getSingleProduct(@PathVariable Long id) {
		return repository.findOne(id);
	}
		
	//PutMapping is an alias for the following:
	//@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	@PutMapping("/{id}")
	public Messdaten update(@PathVariable Long id, @RequestBody Messdaten input) {
		Messdaten m = repository.findOne(id);
		return repository.save(m);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		repository.delete(id);
		return ResponseEntity.ok().build();
	}
}
