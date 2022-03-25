package Grensesnitt;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	Parent rot;
	Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			rot = FXMLLoader.load(getClass().getResource("HovedVindu.fxml"));
			primaryStage.setTitle("Kino");
			primaryStage.setScene(new Scene(rot));
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

// Du ser det her nå


