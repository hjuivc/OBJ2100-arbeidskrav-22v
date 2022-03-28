package Grensesnitt;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class TableViewController implements Initializable{
	
	String kinosalnr;
	int dato;
	Date tidspunkt;
	String pris;
	String film;
	
	public TableViewController(String kinosalnr, int dato, Date tidspunkt, String pris, String film) {
		super();
		this.kinosalnr = kinosalnr;
		this.dato = dato;
		this.tidspunkt = tidspunkt;
		this.pris = pris;
		this.film = film;
	}

	public String getKinosalnr() {
		return kinosalnr;
	}

	public void setKinosalnr(String kinosalnr) {
		this.kinosalnr = kinosalnr;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Date getTidspunkt() {
		return tidspunkt;
	}

	public void setTidspunkt(Date tidspunkt) {
		this.tidspunkt = tidspunkt;
	}

	public String getPris() {
		return pris;
	}

	public void setPris(String pris) {
		this.pris = pris;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}
	
	public TableViewController() {
		// Nædvendig for å instansiere
	}
	
	

	

}
