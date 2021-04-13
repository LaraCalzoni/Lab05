package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAnagramma;

    @FXML
    private Button btnCalcolo;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	String parola = txtAnagramma.getText();
    	Map <String, Boolean> anagrammi = model.anagrammi(parola);
    	List <String> paroleCorrette= new ArrayList <String>();
    	List <String> paroleErrate= new ArrayList <String>();
    	
    if( this.inputValid(parola)==true) {
    	
    	for (String s : anagrammi.keySet() ) {
     			if(anagrammi.get(s) == false ) {
     				paroleErrate.add(s);
     			}
     			else {
     				paroleCorrette.add(s);
     			}
     		}
     		
    	 String elencoC="";
    for(String c : paroleCorrette) {
    	elencoC += c+ "\n";
    }
    
    String elencoE="";
    for(String e : paroleErrate) {
    	elencoE += e+ "\n";
    }
    	this.txtErrati.setText(elencoE);
   	   this.txtCorretti.setText(elencoC);
   	   
    }
    }
   public boolean inputValid(String input) {
	 
	   if(input.length()==0) {
   		txtErrati.setText("Inserire una parola!!!");
   		txtCorretti.setText("Inserire una parola!!!");
   		return false;
   	}
    	if(!input.matches("[a-zA-Z]*")) {
   		txtErrati.setText("Inserire una parola!!!");
   		txtCorretti.setText("Inserire una parola!!!");
   		return false;
   	} 
    	
  return true;
    		   
	   
   }
   
   
    
    @FXML
    void doReset(ActionEvent event) {

    	txtErrati.clear();
    	txtCorretti.clear();
    	txtAnagramma.clear();
    	
    	
    }

    @FXML
    void initialize() {
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolo != null : "fx:id=\"btnCalcolo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m) {
    	this.model=m;
    }
}
