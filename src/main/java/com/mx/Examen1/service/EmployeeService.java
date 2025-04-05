package com.mx.Examen1.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Examen1.entity.Employee;
import com.mx.Examen1.repository.EmployeeRepository;
import com.mx.Examen1.repository.GenderRepository;
import com.mx.Examen1.repository.JobRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	GenderRepository genRepo;

	@Autowired
	JobRepository jobRepo;

	// Guardar
	@Transactional
	public String save(Employee employee) {
		String response = "saved";
		if (genRepo.existsById(employee.getGender().getIdGender())) {
			if (jobRepo.existsById(employee.getJob().getIdJob())) {
				if ((Period.between(employee.getBirthDate(), LocalDate.now())).getYears() >=18) {
					for (Employee emp : empRepo.findAll()) {
						if ((emp.getNameEmployee().equals(employee.getNameEmployee()))
								&& (emp.getLastName().equals(employee.getLastName()))) {
							response = "nameExists";
							break;
						}
					}
				} else
					response = "noOld";
			} else
				response = "noJob";
		} else
			response = "noGender";
		
		if (response.equals("saved")) {
			empRepo.save(employee);
		}
		return response;
	}

	// Mostrar
	@Transactional(readOnly = true)
	public List<Employee> show() {
		return empRepo.findAll();
	}

	// Buscar
	@Transactional(readOnly = true)
	public Employee search(Integer id) {
		return empRepo.findById(id).orElse(null);
	}

	// Editar
	@Transactional
	public void edit(Employee employee) {
		empRepo.save(employee);
	}

	// Eliminar
	@Transactional
	public void delete(Integer id) {
		empRepo.deleteById(id);
	}
}
