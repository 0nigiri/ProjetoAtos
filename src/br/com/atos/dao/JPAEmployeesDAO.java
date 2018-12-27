package br.com.atos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.atos.model.Employees;

/*
 * Classe JPA
 * @author  Thiago Onishi
 * 
 */

@Repository
public class JPAEmployeesDAO implements EmployeesDAO {

	@PersistenceContext
	EntityManager manager;

	// Metodo de adicionar os dados para o Banco de dados
	@Transactional
	public void adiciona(Employees employees) {
		manager.persist(employees);
	}

}
