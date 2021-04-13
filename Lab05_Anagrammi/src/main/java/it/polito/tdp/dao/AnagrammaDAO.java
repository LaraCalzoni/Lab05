package it.polito.tdp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagrammaDAO {

	
	

	
	public Map <String, Boolean> anagrammi(String parola){
		Map <String, Boolean> soluzione = new HashMap <>();
		this.doRicorsione("",parola,0, soluzione);
		
		return soluzione;
	}
	

	                       //soluzionep --> soluzione parziale //lettere--> quelle che rimangono
	private void doRicorsione(String soluzionep, String lettere, int livello, Map <String, Boolean> soluzione) {
	
		//caso terminale
	if(lettere.length()==0) {
		
	soluzione.put(soluzionep, this.isValid(soluzionep));	
		
	}
		
	else { 
		// D O G --> D soluz. parziale | O, G lettere
	for(int i=0; i< lettere.length(); i++) {
		
		char c = lettere.charAt(i);
		String nuovaParziale= soluzionep+c;
		String nuoveLettere = lettere.substring(0,i)+lettere.substring(i+1);
		
		this.doRicorsione(nuovaParziale, nuoveLettere, livello+1, soluzione);
			
	}
		
		
	}
	
		
	}
	 
	
	public boolean isValid (String parola) {
		
		String sql= "SELECT * "
				+ "FROM parola "
				+ "WHERE parola.nome = ?";
		
		boolean valido = false;
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()==true) {
				conn.close();
				valido=true;
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return valido;
			
		} 
		
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore nel Database.", e);
			
		}
		
		
	
	}
	
	
	
}
