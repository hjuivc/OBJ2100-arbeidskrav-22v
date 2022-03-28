package Grensesnitt;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	Parent rot;
	Controller control;
	Stage stage;
	
	@Override
	public void start(Stage stage) {
		try {
			rot = FXMLLoader.load(getClass().getResource("HovedVindu.fxml"));
			stage.setTitle("Kino");
			stage.setScene(new Scene(rot));
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}




