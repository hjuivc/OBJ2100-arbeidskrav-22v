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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdministrasjonController {
	
	@FXML
	private Label administrasjon;
	
	@FXML
	private Label leggtilfim;
	
	@FXML
	private Label visning;
	
	@FXML
	private TextField nyfilm;
	
	@FXML
	private TextField nyvisning;
	
	@FXML
	private Button tilbakeadministrasjon;
	
	public AdministrasjonController() {
		
	}
	
	// Instansiering
	@FXML
	public void Initialize() {
	}

	@FXML
	public void tilbakeAdministrasjon(ActionEvent e) throws IOException {
		Parent administrasjonParent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
		Scene scene2 = new Scene(administrasjonParent);
		Stage vindu = (Stage) ((Node)e.getSource()).getScene().getWindow();
		vindu.setScene(scene2);
		vindu.show();
	}

}
