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
import javafx.stage.Stage;

public class PlanleggerController {
	
	@FXML
	private Label overskrift;
	
	@FXML
	private Button administrasjon;
	
	@FXML
	private Button rapport;
	
	@FXML
	private Button tilbake;
	
	@FXML
	public void tilAdministrasjon(ActionEvent e) throws IOException {
		Parent scene3Parent = FXMLLoader.load(getClass().getResource("scene3.fxml"));
		Scene scene3 = new Scene(scene3Parent);
		
		// Denne linja får Stage informasjonen
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		window.setScene(scene3);
		window.show();
	}
	
	@FXML
	public void tilRapport(ActionEvent e) throws IOException {
		Parent scene4Parent = FXMLLoader.load(getClass().getResource("scene4.fxml"));
		Scene scene4 = new Scene(scene4Parent);
		
		// Denne linja får Stage informasjonen
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		window.setScene(scene4);
		window.show();
	}
	
	@FXML
	public void tilbake(ActionEvent e) throws IOException {
		Parent hovedvinduParent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
		Scene scene1 = new Scene(hovedvinduParent);
		Stage vindu = (Stage) ((Node)e.getSource()).getScene().getWindow();
		vindu.setScene(scene1);
		vindu.show();
	}

}
