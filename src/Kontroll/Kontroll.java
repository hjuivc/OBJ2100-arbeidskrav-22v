package Kontroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kontroll {
	private String databasenavn = "jdbc:mysql://localhost:3306/kino";
	private String databasedriver = "com.mysql.jdbc.Driver";
	public Connection forbindelse;
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
	
	public ResultSet hentKinoprogram() throws Exception  {
		ResultSet resultat = null;
		String sql = "SELECT tblvisning.v_kinosalnr, tblvisning.v_dato, tblvisning.v_starttid, tblvisning.v_pris, tblfilm.f_filmnavn\r\n"
				+ "FROM tblvisning, tblfilm\r\n"
				+ "WHERE tblvisning.v_filmnr = tblfilm.f_filmnr\r\n"
				+ "ORDER BY tblvisning.v_dato ASC, tblvisning.v_starttid ASC";
		try {
			utsagn = forbindelse.createStatement();
			resultat = utsagn.executeQuery(sql);
		} catch(Exception e) {throw new Exception("Kan ikke åpne databasetabell");}
		return resultat;
	}

	
	
}
