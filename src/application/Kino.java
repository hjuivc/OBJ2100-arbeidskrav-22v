package application;

import java.sql.Date;
import java.sql.Time;

public class Kino {
	private int kinosalnr;
	private Date dato;
	private Time starttid;
	private double pris;
	private String film;
	
	public Kino(int kinosalnr, Date dato, Time starttid, double pris, String film) {
		this.kinosalnr = kinosalnr;
		this.dato = dato;
		this.starttid = starttid;
		this.pris = pris;
		this.film = film;
	}

	public int getKinosalnr() {
		return kinosalnr;
	}

	public void setKinosalnr(int kinosalnr) {
		this.kinosalnr = kinosalnr;
	}

	public Date getDato() {
		return dato;
	}

	public void setDato(Date dato) {
		this.dato = dato;
	}

	public Time getStarttid() {
		return starttid;
	}

	public void setStarttid(Time starttid) {
		this.starttid = starttid;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	@Override
	public String toString() {
		return "Kino [kinosalnr=" + kinosalnr + ", dato=" + dato + ", starttid=" + starttid + ", pris=" + pris
				+ ", film=" + film + "]";
	}
	
	
	

}
