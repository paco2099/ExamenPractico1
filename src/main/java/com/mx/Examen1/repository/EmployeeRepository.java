package com.mx.Examen1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Examen1.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
