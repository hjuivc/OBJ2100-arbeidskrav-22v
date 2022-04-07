package application;

import java.io.IOException;
import java.sql.DriverManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HovedController {
	DatabaseKontroll kontroll = new DatabaseKontroll();
	
	@FXML
	private Label overskrift;
	
	@FXML
	private Button planlegger;
	
	@FXML
	private Button betjening;
	
	@FXML
	private Button kunde;
	
	@FXML
	private Button kobledatabase;
	
	@FXML
	private Button stengdatabase;
	
	@FXML
	private Button avslutt;
	
	
	// Koble opp database
	@FXML
	public void hentForbindelse() throws Exception {
		kontroll.lagForbindelse();
	}
	
	@FXML
	public void stengForbindelse() throws Exception {
		kontroll.lukk();
	}
	
	// Navigering gjennom applikasjonen
	@FXML
	public void bytteVindu(ActionEvent e) throws IOException {
		Parent scene2Parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
		Scene scene2 = new Scene(scene2Parent);
		
		// Denne linja får Stage informasjonen
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		window.setScene(scene2);
		window.show();
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
	
	@FXML
	public void tilKunde(ActionEvent e) throws Exception {
		System.out.println("heihei");
		FXMLLoader scene6Loader = new FXMLLoader(getClass().getResource("scene6.fxml"));
		Parent scene6Parent = scene6Loader.load();
		KundeController kundecontroller = (KundeController) scene6Loader.getController();
		Scene scene6 = new Scene(scene6Parent);
		kundecontroller.brukInnhold(new ActionEvent());
		kundecontroller.oppsettFilm();
		
		// Denne linja får Stage informasjonen
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		window.setScene(scene6);
		window.show();
	}

	
	// Avslutte applikasjon
	@FXML
	public void avslutt(ActionEvent e) throws IOException {
		System.exit(0);	
	}
	
	public HovedController() {
		
	}
	
	// Instansiering
	@FXML
	public void Initialize() {
	}

}
