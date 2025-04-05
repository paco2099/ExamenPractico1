package com.mx.Examen1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Examen1.entity.WorkedHours;
import com.mx.Examen1.service.WorkedHoursService;

@RestController
@RequestMapping(path = "hoursWeb")
@CrossOrigin
public class WorkedHoursController {
	@Autowired
	WorkedHoursService hourServ;
	
	@PostMapping(path = "save")
	public ResponseEntity<?> save(@RequestBody WorkedHours hours){
		String response = hourServ.save(hours);
		if (response.equals("noEmployee")) {
			return new ResponseEntity<>("Error: Employee does not exist", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>("Worked hours created", HttpStatus.OK);
		}
	}
	
	@GetMapping(path = "show")
	public List<WorkedHours> show(){
		return hourServ.show();
	}
	
	@GetMapping(path = "search")
	public WorkedHours search(@RequestBody WorkedHours hours) {
		return hourServ.search(hours.getIdWork());
	}
	
	@PostMapping(path = "edit")
	public ResponseEntity<?> edit(@RequestBody WorkedHours hours){
		hourServ.edit(hours);
		return new ResponseEntity<>("Report edited", HttpStatus.OK);
	}
	
	@PostMapping(path = "delete")
	public ResponseEntity<?> delete(@RequestBody WorkedHours hours){
		hourServ.delete(hours.getIdWork());
		return new ResponseEntity<>("Report deleted", HttpStatus.OK);
	}
}
