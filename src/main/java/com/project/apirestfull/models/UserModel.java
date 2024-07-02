package com.project.apirestfull.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Table(name = "usuario")

public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Size(min = 5 , message = "{nome.min}")
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	@Email(message = "{email.not.valid}")
	@NotBlank(message = "{email.not.blank}")
	private String email;
	@Size(max = 15, min= 5, message= "{telefone.size}")
	@NotBlank(message = "{telefone.not.blank}")
	private String telefone;
	
	
	@ManyToOne
	@JoinColumn(name = "empresa", referencedColumnName = "id_empresa")
	private EmpresaModel empresa;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public UserModel() {

	}

    public EmpresaModel getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }
}