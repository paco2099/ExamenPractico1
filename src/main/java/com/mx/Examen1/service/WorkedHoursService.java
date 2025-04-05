package com.mx.Examen1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Examen1.entity.WorkedHours;
import com.mx.Examen1.repository.EmployeeRepository;
import com.mx.Examen1.repository.WorkedHoursRepository;

@Service
public class WorkedHoursService {
	@Autowired 
	WorkedHoursRepository wHRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	//Guardar
	@Transactional
	public String save(WorkedHours hours) {
		String response = "saved";
		if (!empRepo.existsById(hours.getEmployee().getIdEmployee())) {
			response = "noEmployee";
		} else {
			wHRepo.save(hours);
		}
		
		return response;
	}
	
	//Mostrar
	@Transactional(readOnly = true)
	public List<WorkedHours> show(){
		return wHRepo.findAll();
	}
	
	//Buscar
	@Transactional(readOnly = true)
	public WorkedHours search(Integer id) {
		return wHRepo.findById(id).orElse(null);
	}
	
	//Editar
	@Transactional
	public void edit(WorkedHours hours) {
		wHRepo.save(hours);
	}
	
	//Editar
		@Transactional
		public void delete (Integer id) {
			wHRepo.deleteById(id);
		}
}
