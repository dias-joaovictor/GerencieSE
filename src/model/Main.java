package model;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
//			Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaLogin.fxml"));
//			Scene cenaTelaLogin = new Scene(parent, 350, 300);
			
//			
			Parent parent = FXMLLoader.load(getClass().getResource("../view/QuadroPrincipal.fxml"));
			Scene cenaTelaLogin = new Scene(parent, 800, 600); 
			primaryStage.setScene(cenaTelaLogin);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}