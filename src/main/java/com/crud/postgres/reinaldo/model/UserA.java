package com.crud.postgres.reinaldo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usera")
public class UserA {

	public UserA() {
		super();
	}

	
	
	public UserA(Long id_user, String name, String password, String login,
			profissao profissao, Department department, List<Role> roles) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.password = password;
		this.login = login;
		this.profissao = profissao;
		this.department = department;
		this.roles = roles;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;

	@Column
	private String name;

	@Column
	private String password;

	@Column
	private String login;

	@OneToOne()
	@JoinColumn(name = "profissao_id", referencedColumnName = "id_profissao")
    private profissao profissao;
	
	@OneToOne()
	@JoinColumn(name = "department_id", referencedColumnName = "id_department")
	private Department department;
	
	@OneToMany()
	@JoinColumn(name = "user_role_id")
	private List<Role> roles;

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(profissao profissao) {
		this.profissao = profissao;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
