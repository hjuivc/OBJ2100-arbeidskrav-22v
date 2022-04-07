package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	// Scene 1
	@FXML
	private Button planlegger;
	
	@FXML
	private Button administrasjon;
	
	@FXML
	private Button rapport;
	
	@FXML
	private Button tilbake;
	
	// Scene 2
	@FXML
	private Label kinosentral;
	
	@FXML
	private Label kinosentralen;
	
	@FXML
	private Label leggtilfilm;
	
	@FXML
	private Label visning;
	
	@FXML
	private TextField nyfilm;
	
	@FXML
	private TextField nyvisning;
	
	@FXML
	private Button tilbakeadministrasjon;
	
	// Scene 3
	@FXML
	private Label rapporten;
	
	@FXML
	private Label billettsalg;
	
	@FXML
	private TableColumn billettColumn;
	
	@FXML
	private Label statistikk;
	
	@FXML
	private ListView liste1;
	
	@FXML
	private Button tilbakeRapport;
	
	// Scene 5
	@FXML
	private Label betjening;
	
	@FXML
	private Button betaling;
	
	@FXML
	private Button salg;
	
	@FXML
	private Button avbestilling;
	
	@FXML
	private Button tilbakeBetjening;
	
	// Scene 6
	
	
	public Controller() {
		// Nødvendig for å instansiere
	}
	
	
	
	
	@FXML
	public void tilbake(ActionEvent e) throws IOException {
		Parent hovedvinduParent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
		Scene scene1 = new Scene(hovedvinduParent);
		Stage vindu = (Stage) ((Node)e.getSource()).getScene().getWindow();
		vindu.setScene(scene1);
		vindu.show();
	}
	
	
	
	
	
	
	
	
	
	@FXML
	public void tilBetjening(ActionEvent e) throws IOException {
		Parent scene5Parent = FXMLLoader.load(getClass().getResource("scene5.fxml"));
		Scene scene5 = new Scene(scene5Parent);
		
		// Denne linja får Stage informasjonen
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		window.setScene(scene5);
		window.show();
	}
	
	
	
	public void tilKunde(ActionEvent e) throws Exception {
		System.out.println("heihei");
		FXMLLoader scene6Loader = FXMLLoader.load(getClass().getResource("scene6.fxml"));
		Parent scene6Parent = scene6Loader.load();
		KundeController kundecontroller = (KundeController) scene6Loader.getController();
		Scene scene6 = new Scene(scene6Parent);
		kundecontroller.brukInnhold(new ActionEvent());
		
		// Denne linja får Stage informasjonen
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		window.setScene(scene6);
		//window.show();
	}
	
	
	
	// Instansiering
	@FXML
	public void Initialize() {
	}
	
	// Avslutte applikasjon
	@FXML
	public void avslutt(ActionEvent e) throws IOException {
		System.exit(0);	
	}

}
