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

import com.mx.Examen1.entity.Gender;
import com.mx.Examen1.service.GenderService;

@RestController
@RequestMapping(path = "genderWeb")
@CrossOrigin
public class GenderController {
	@Autowired
	GenderService genServ;
	
	@PostMapping(path = "save")
	public ResponseEntity<?> save(@RequestBody Gender gender){
		boolean response = genServ.save(gender);
		if (!response) {
			return new ResponseEntity<>("Saved.", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Fail.", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "show")
	public List<Gender> show(){
		return genServ.show();
	}
	
	@PostMapping(path = "search")
	public Gender search(@RequestBody Gender gender) {
		return genServ.search(gender.getIdGender());
	}
	
	@PostMapping(path = "edit")
	public ResponseEntity<?> edit(@RequestBody Gender gender){
		genServ.edit(gender);
		return new ResponseEntity<>("Edited.", HttpStatus.OK);
	}
	
	@PostMapping(path = "delete")
	public ResponseEntity<?> delete(@RequestBody Gender gender){
		genServ.delete(gender.getIdGender());
		return new ResponseEntity<>("Deleted.", HttpStatus.OK);
	}
}
