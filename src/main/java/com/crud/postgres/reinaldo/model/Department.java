package com.crud.postgres.reinaldo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "department")
public class Department {

	public Department() {
		super();
	}

	public Department(Long id_department, String name) {
		super();
		this.id_department = id_department;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_department;

	private String name;

	public Long getId_department() {
		return id_department;
	}

	public void setId_department(Long id_department) {
		this.id_department = id_department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
