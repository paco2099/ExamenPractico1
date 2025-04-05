package com.mx.Examen1.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE JOBS(
ID NUMBER PRIMARY KEY,
NAME VARCHAR2(255),
SALARY NUMBER NOT NULL
);*/

@Entity
@Table(name = "JOBS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Job {
	@Id
	@Column(name = "ID")
	private Integer idJob;
	
	@Column(name = "NAME")
	private String nameJob;
	
	@Column(name = "SALARY")
	private Float salaryJob;
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employee> list = new ArrayList<>();
}
