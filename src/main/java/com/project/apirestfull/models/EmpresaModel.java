package com.project.apirestfull.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "empresa")
public class EmpresaModel {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id_empresa")
	private int id_empresa;
	
	@Size(min = 5 , message = "{nome.min}")
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	
	@Size(min = 5 , message = "{ramo.min}")
	@NotBlank(message = "{ramo.not.blank}")
	private String ramo;
	
	
	
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	

}