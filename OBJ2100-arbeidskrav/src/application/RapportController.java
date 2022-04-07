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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class RapportController {
	
	@FXML
	private Label rapporten;
	
	@FXML
	private Label billettsalg;
	
	@FXML
	private Label statistikk;
	
	@FXML
	private TableView billettColumn;
	
	@FXML
	private ListView liste1;
	
	@FXML
	private Button tilbakeRapport;
	
	public RapportController() {
		
	}
	
	// Instansiering
	@FXML
	public void Initialize() {
	}
	
	@FXML
	public void tilbakeRapport(ActionEvent e) throws IOException {
		Parent rapportParent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
		Scene scene2 = new Scene(rapportParent);
		Stage vindu = (Stage) ((Node)e.getSource()).getScene().getWindow();
		vindu.setScene(scene2);
		vindu.show();
	}

}
