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

/*CREATE TABLE GENDERS(
ID NUMBER PRIMARY KEY,
NAME VARCHAR2(255)
);*/

@Entity
@Table (name = "GENDERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Gender {
	@Id
	@Column(name = "ID")
	private Integer idGender;
	
	@Column(name = "NAME")
	private String nameGender;
	
	@OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Employee> list = new ArrayList<>();
}
