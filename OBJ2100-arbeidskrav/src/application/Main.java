package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	Parent hovedvindu;
	Controller control;
	Stage stage;
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent hovedvindu = FXMLLoader.load(getClass().getResource("scene1.fxml"));
		Scene scene1 = new Scene(hovedvindu);
		stage.setScene(scene1);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
