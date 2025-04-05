package com.mx.Examen1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.Examen1.entity.Job;
import com.mx.Examen1.repository.JobRepository;

@Service
public class JobService {
	@Autowired
	JobRepository jobRepo;

	// Guardar
	@Transactional
	public void save(Job job) {
		jobRepo.save(job);
	}

	// Mostrar
	@Transactional(readOnly = true)
	public List<Job> show() {
		return jobRepo.findAll();
	}

	// Buscar
	@Transactional(readOnly = true)
	public Job search(Integer id) {
		return jobRepo.findById(id).orElse(null);
	}

	// Editar
	@Transactional
	public void edit(Job job) {
		jobRepo.save(job);
	}

	// Eliminar
	@Transactional
	public void delete(Integer id) {
		jobRepo.deleteById(id);
	}
}
