package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class DatabaseKontroll {
	
	private String databasenavn = "jdbc:mysql://localhost:3306/kino";
	private String databasedriver = "com.mysql.jdbc.Driver";
	public Connection forbindelse;
	private ResultSet resultat;
	private Statement utsagn;
	
	
	
	
	public void lagForbindelse() throws Exception {
		try {
			forbindelse = DriverManager.getConnection(databasenavn, "root", "");
			System.out.println("Databasen er tilkoblet");
		} catch(Exception e) {
			throw new Exception("Kan ikke oppnå kontakt med databasen");
		}
	}
	
	public void lukk() throws Exception {
		try {
			if (forbindelse != null) {
				forbindelse.close();
				resultat.close();
				utsagn.close();
				System.out.println("Databasen er stengt");
			}
		} catch(Exception e) {
			throw new Exception("Kan ikke lukke databaseforbindelsen");
		}
	}
	
	
	

}


