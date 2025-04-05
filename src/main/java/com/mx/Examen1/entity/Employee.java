package com.mx.Examen1.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE EMPLOYEES(
ID NUMBER PRIMARY KEY,
GENDER_ID NUMBER NOT NULL,
JOB_ID NUMBER NOT NULL,
NAME VARCHAR2(255) NOT NULL,
LAST_NAME VARCHAR2(255) NOT NULL,
BIRTHDATE DATE NOT NULL,
FOREIGN KEY (GENDER_ID) REFERENCES GENDERS(ID),
FOREIGN KEY (JOB_ID) REFERENCES JOBS(ID)
);*/

@Entity
@Table(name = "EMPLOYEES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
	@Id
	@Column(name = "ID")
	private Integer idEmployee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	Gender gender;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID")
	Job job;
	
	@Column(name = "NAME")
	private String nameEmployee;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "BIRTHDATE")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	@JsonIgnore
	List<WorkedHours> list = new ArrayList<>();
}
