package com.mx.Examen1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Examen1.entity.Gender;
import com.mx.Examen1.repository.GenderRepository;

@Service
public class GenderService {
	@Autowired
	GenderRepository genRepo;
	
	//Guardar
	@Transactional
	public boolean save(Gender gender) {
		boolean exists = false;
		for (Gender g : genRepo.findAll()) {
			if (g.getIdGender().equals(gender.getIdGender())) {
				exists = true;
				break;
			}
		}
		if (!exists) {
			genRepo.save(gender);
		}
		return exists;
	}
	
	//Mostrar
	@Transactional(readOnly = true)
	public List<Gender> show() {
		return genRepo.findAll();
	}
	
	//Buscar 
	@Transactional(readOnly = true)
	public Gender search(Integer id) {
		return genRepo.findById(id).orElse(null);
	}
	
	//Editar
	@Transactional
	public void edit(Gender gender) {
		genRepo.save(gender);
	}
	
	//Eliminar
	@Transactional
	public void delete (Integer id) {
		genRepo.deleteById(id);
	}
	
}
