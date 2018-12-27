package br.com.atos.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import br.com.atos.controller.ControllerThiago;
import br.com.atos.model.Employees;



/**
 * classe para Teste  JUnit.
 * 
 * @author Thiago Onishi
 *
 */

@SuppressWarnings("unused")
@RunWith(MockitoJUnitRunner.class)
public class JunitControllerTest {
	
	private ControllerThiago controllerThiago;
	
    @Mock
    private Model model;
    
    @Mock
    Employees employeers = new Employees();
    
  
    

	
	@Before
	public void setUp() throws Exception {
		controllerThiago = new ControllerThiago();
	}
	

	/*
	 * Teste na pagina de lista de funcionario
	 */
	@Test
	public void testIndexJsonRequest() {
		String teste = controllerThiago.listaEmployees(model);
        assertEquals("EmployeeList", teste);
	}
	


}
