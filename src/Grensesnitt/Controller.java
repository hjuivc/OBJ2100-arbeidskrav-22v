package Grensesnitt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;

import Kontroll.Kontroll;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class Controller {
	private Connection forbindelse;
	Kontroll kontroll;
	
	public Controller() {
		// Nødvendig for å instansiere
	}
	
	// KundeVindu
	@FXML
	private Button kunde;
	
	@FXML
	private Button planlegger;
	
	@FXML
	private Button kinobetjent;
	
	@FXML
	private Label test;
	
	@FXML
	private Button avslutt;
	
	@FXML
	private Button tilbake;


    
	

	
	// Lytter
	@FXML
	public void behandleKundeKnapp(ActionEvent e) throws IOException {
		Parent kundevinduParent = FXMLLoader.load(getClass().getResource("KundeVindu.fxml"));
		Scene kunde = new Scene(kundevinduParent);
		
		// Denne linja får Stage informasjonen
		Stage kundevindu = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		kundevindu.setScene(kunde);
		kundevindu.show();
		
	}
	
	@FXML
	public void behandleBetjentKnapp(ActionEvent e) throws IOException {
		Parent betjentvinduParent = FXMLLoader.load(getClass().getResource("BetjentVindu.fxml"));
		Scene betjent = new Scene(betjentvinduParent);
		
		// Denne linja får Stage informasjonen
		Stage betjentvindu = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		betjentvindu.setScene(betjent);
		betjentvindu.show();
		
	}
	
	@FXML
	public void behandlePlanleggingknapp(ActionEvent e) throws IOException {
		Parent planleggingvinduParent = FXMLLoader.load(getClass().getResource("PlanleggingVindu.fxml"));
		Scene planlegging = new Scene(planleggingvinduParent);
		
		// Denne linja får Stage informasjonen
		Stage planleggingvindu = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		planleggingvindu.setScene(planlegging);
		planleggingvindu.show();
		
	}
	
	@FXML
	public void tilbake(ActionEvent e) throws IOException {
		Parent hovedvinduParent = FXMLLoader.load(getClass().getResource("HovedVindu.fxml"));
		Scene hovedvindu = new Scene(hovedvinduParent);
		Stage vindu = (Stage) ((Node)e.getSource()).getScene().getWindow();
		vindu.setScene(hovedvindu);
		vindu.show();
	}
	
	
	@FXML
	public void Initialize() {

	}
	
	// Avslutte applikasjon
	@FXML
	public void avsluttKnapp(ActionEvent e) throws IOException {
		System.exit(0);	
	}
	
	public void visKinoprogram(SortEvent e) throws Exception {
		kontroll.lagForbindelse();
		kontroll.hentKinoprogram();
		System.out.println("hei");
		try {
			ResultSet resultat = kontroll.hentKinoprogram();
			while (resultat.next()) {
				String kinosalnr = resultat.getString(1);
				int dato = resultat.getInt(2);
				Date tidspunkt = resultat.getDate(3);
				String pris = resultat.getString(4);
				String film = resultat.getString(5);
				System.out.format("%s, %s, %s, %s, %sn", kinosalnr, dato, tidspunkt, pris, film);
			}
		} catch(Exception e1) {System.out.println(e1.getMessage());}
		
	}
	
	
}
