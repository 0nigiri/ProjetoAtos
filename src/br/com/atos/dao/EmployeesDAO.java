package br.com.atos.dao;

import br.com.atos.model.Employees;

/*
 * Classe interface para o DAO
 * @author  Thiago Onishi
 * 
 */
public interface EmployeesDAO {
	
	//Adicionar o JSON para o banco de dados
	void adiciona(Employees employees);
}
