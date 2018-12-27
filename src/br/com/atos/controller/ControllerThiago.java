package br.com.atos.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.atos.dao.EmployeesDAO;
import br.com.atos.model.Employees;
import br.com.atos.util.JSONUtil;

/*
 * Classe Controller
 * @author  Thiago Onishi
 * 
 */

@Controller
public class ControllerThiago {

	@Autowired
	EmployeesDAO dao;

	/*
	 * Pagina inicial, onde mostra uma lista dos employeees cadastrados no banco de
	 * dados em uma tabela contendo o nome, cargo e o salario
	 */
	@RequestMapping(value = "/EmployeeList")
	public String listaEmployees(Model model) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("market");
		EntityManager manager = factory.createEntityManager();

		List<Employees> listEmployees = manager.createQuery("SELECT employee FROM Employees employee ").getResultList();

		model.addAttribute("employees", listEmployees);

		manager.close();
		factory.close();

		return "EmployeeList";
	}

	
	/*
	 * Pagina onde se faz um upload de um arquivo JSON e envia para o banco de dados
	 */
	@RequestMapping(value = "/addJsonPage")
	public String addJsonPage() {

		return "addJson";
	}

	
	/*
	 * O arquivo JSON foi convertido para um String(jsonString) , onde primeiro passa por uma verificacao
	 * se so Json e valido ou nao, e entao  converte o String para o objeto,
	 *  caso String estiver vazio ou nao nao estiver na sintaxe
	 * correta ela ira retornar a pagina anterior
	 */
	@RequestMapping(value = "/AddJson")
	public String addJson(String jsonString) {
		JSONUtil util = new JSONUtil();
		Boolean verify;
		System.out.println(jsonString);

		verify = util.isJSONValid(jsonString);

		if (verify == true) {
			Gson gson = new Gson();

			try {

				Employees[] employees = new Gson().fromJson(jsonString, Employees[].class);
				List<Employees> asList = Arrays.asList(employees);

				for (int i = 0; i < employees.length; i++) {
					System.out.println(employees[i].getCodEmployees() + " " + employees[i].getName() + " "
							+ employees[i].getRole() + " " + employees[i].getSalary());

					dao.adiciona(employees[i]);
				}

			} catch (JsonSyntaxException e) {
				System.out.println("Erro, possivelmente a String estava com valor invalido" + e);
				e.printStackTrace();
			} catch (PersistenceException e) {
				System.out.println("Erro, erro ao tentar enviar o Json no sql" + e);
				e.printStackTrace();
			}

			return "redirect:EmployeeList";
		} else if (verify == false) {
			return "redirect:addJsonPage";
		}
		return "redirect:addJsonPage";

	}

}
