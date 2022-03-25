package Kontroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kontroll {
	private String databasenavn = "jdbc:mysql://localhost:3306/kino";
	private String databasedriver = "com.mysql.jdbc.Driver";
	private Connection forbindelse;
	private ResultSet resultat;
	private Statement utsagn;



	public void lagForbindelse() throws Exception {
		try {
			forbindelse = DriverManager.getConnection(databasenavn, "Case", "Esac");
			System.out.println("Kontakt oppnådd");
		} catch(Exception e) {
			throw new Exception("Kan ikke oppnå kontakt med databasen");
		}
	}
	
	
}
