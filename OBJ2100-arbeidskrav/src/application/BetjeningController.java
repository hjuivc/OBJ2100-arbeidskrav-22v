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

public class BetjeningController {
	
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
	
	public BetjeningController() {
		
	}
	
	// Instansiering
	@FXML
	public void Initialize() {
	}
	
	@FXML
	public void tilbakeBetjening(ActionEvent e) throws IOException {
		Parent betjeningParent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
		Scene scene1 = new Scene(betjeningParent);
		Stage vindu = (Stage) ((Node)e.getSource()).getScene().getWindow();
		vindu.setScene(scene1);
		vindu.show();
	}

}
