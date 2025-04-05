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

import com.mx.Examen1.entity.Employee;
import com.mx.Examen1.service.EmployeeService;

@RestController
@RequestMapping(path = "empWeb")
@CrossOrigin
public class EmployeeController {
	@Autowired
	EmployeeService empServ;

	@PostMapping(path = "save")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		String response = empServ.save(employee);
		if (response.equals("nameExists")) {
			return new ResponseEntity<>("Error: Name already exist", HttpStatus.BAD_REQUEST);
		} else if (response.equals("noOld")) {
			return new ResponseEntity<>("Error: Employee is not a adult", HttpStatus.BAD_REQUEST);
		} else if (response.equals("noJob")) {
			return new ResponseEntity<>("Error: Job does not exist", HttpStatus.BAD_REQUEST);
		}else if (response.equals("noGender")) {
			return new ResponseEntity<>("Error: Gender does not exist", HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>("Employee created.", HttpStatus.OK);
		}
	}

	@GetMapping(path = "show")
	public List<Employee> show() {
		return empServ.show();
	}

	@GetMapping(path = "search")
	public Employee search(@RequestBody Employee employee) {
		return empServ.search(employee.getIdEmployee());
	}

	@PostMapping(path = "edit")
	public ResponseEntity<?> edit(@RequestBody Employee employee) {
		empServ.edit(employee);
		return new ResponseEntity<>("Employee edited.", HttpStatus.OK);
	}

	@PostMapping(path = "delete")
	public ResponseEntity<?> delete(@RequestBody Employee employee) {
		empServ.delete(employee.getIdEmployee());
		return new ResponseEntity<>("Employee deleted.", HttpStatus.OK);
	}
}
