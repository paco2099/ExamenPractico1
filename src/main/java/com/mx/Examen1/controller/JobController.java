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

import com.mx.Examen1.entity.Job;
import com.mx.Examen1.service.JobService;

@RestController
@RequestMapping(path = "jobWeb")
@CrossOrigin
public class JobController {
	@Autowired
	JobService jobServ;
	
	@PostMapping(path = "save")
	public ResponseEntity<?> save(@RequestBody Job job){
		jobServ.save(job);
		return new ResponseEntity<>("Job saved.", HttpStatus.OK);
	}
	
	@GetMapping(path = "show")
	public List<Job> show(){
		return jobServ.show();
	}
	
	@GetMapping(path = "search")
	public Job search(@RequestBody Job job) {
		return jobServ.search(job.getIdJob());
	}
	
	@PostMapping(path = "edit")
	public ResponseEntity<?> edit(@RequestBody Job job){
		jobServ.edit(job);
		return new ResponseEntity<>("Job edited.", HttpStatus.OK);
	}
	
	@PostMapping(path = "delete")
	public ResponseEntity<?> delete(@RequestBody Job job){
		jobServ.delete(job.getIdJob());
		return new ResponseEntity<>("Job deleted.", HttpStatus.OK);
	}
}
