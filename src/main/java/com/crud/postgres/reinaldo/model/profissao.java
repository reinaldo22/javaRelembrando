package com.crud.postgres.reinaldo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profissao")
public class profissao {
	
	
	public profissao() {
		super();
	}
	
	

	public profissao(Long id_profissao, String nome) {
		super();
		this.id_profissao = id_profissao;
		this.nome = nome;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_profissao;

	@Column()
	private String nome;

	public Long getId_profissao() {
		return id_profissao;
	}

	public void setId_profissao(Long id_profissao) {
		this.id_profissao = id_profissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
