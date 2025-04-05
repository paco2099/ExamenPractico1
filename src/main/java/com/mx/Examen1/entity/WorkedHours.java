package com.mx.Examen1.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*CREATE TABLE EMPLOYEE_WORKED_HOURS(
ID NUMBER PRIMARY KEY,
EMPLOYEE_ID NUMBER NOT NULL,
WORKED_HOURS NUMBER NOT NULL,
WORKED_DATE DATE NOT NULL,
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES(ID)
);*/

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkedHours {
	@Id
	@Column(name = "ID")
	private Integer idWork;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID")
	Employee employee;
	
	@Column(name = "WORKED_HOURS")
	private Integer workedHours;
	
	@Column(name = "WORKED_DATE")
	private LocalDate workDate;
}
