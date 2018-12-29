package br.com.atos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Classe funcionarios
 * @author  Thiago Onishi
 * Criar um novo schema no sql chamado projeto_atos para o hibernate criar as tabelas
 */


@Entity
@Table(name = "employees")
public class Employees {

	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "cod_employees")
	private long codEmployees;

	
	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("role")
	@Expose
	@Column(name = "role")
	private String role;

	@SerializedName("salary")
	@Expose
	private String salary;



	public long getCodEmployees() {
		return codEmployees;
	}

	public void setCodEmployees(long codEmployees) {
		this.codEmployees = codEmployees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	


}
