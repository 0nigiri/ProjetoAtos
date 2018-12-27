package br.com.atos.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Classe utilidade
 * @author  Thiago Onishi
 * 
 */

public class JSONUtil {
	

	
		//Metodo para verificar se a String do JSON e valida
		public boolean isJSONValid(String jsonString) {
			
			
			 try {
			       final ObjectMapper mapper = new ObjectMapper();
			       mapper.readTree(jsonString);
			       return true;
			    } catch (IOException e) {
			       return false;
			    }
			  }
	

		
	
}
