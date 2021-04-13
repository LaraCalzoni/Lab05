package it.polito.tdp.model;

import java.util.Map;

import it.polito.tdp.dao.AnagrammaDAO;

public class Model {

	private AnagrammaDAO anagrammaDAO;
	
	public Model() {
		anagrammaDAO= new AnagrammaDAO();
	}
	
	public Map <String, Boolean> anagrammi(String parola){
	     return	anagrammaDAO.anagrammi(parola);
		
	}
}
