package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import registrazione.Scena2Controller;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	/*
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("scena1.fxml"));
			Scene scene = new Scene(root);		
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
	private static Stage stg;

	@Override
	public void start(Stage primaryStage) {

		try {
			stg = primaryStage;
			primaryStage.setResizable(false);
			Parent root = FXMLLoader.load(getClass().getResource("mainS.fxml"));
			Scene scene = new Scene(root, 450, 650);
			primaryStage.setTitle("Emotional Songs");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scenaMenuPrincipale(String fxml) throws IOException {
		Parent root2 = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(root2);  //carica la scena dopo login
	}
	

	public void scenaDopoLogin(String fxml,String changeUser) throws IOException {

		Parent root2; 
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		root2 = loader.load();
		
		DopoLogin dopologin = loader.getController();
		dopologin.displayName(changeUser);
		
		//root = FXMLLoader.load(getClass().getResource("scena2.fxml"));
		
		//stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		//scene = new Scene(root2);		
		stg.getScene().setRoot(root2);
		stg.show();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
