package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	private static Stage stg;

	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			primaryStage.setResizable(false);
			Parent root = FXMLLoader.load(getClass().getResource("nameCanzone.fxml"));
			Scene scene = new Scene(root, 450, 650);
			primaryStage.setTitle("Emotional Songs");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scenaMenuPrincipale(String fxml) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(root);  //carica la scena dopo login
	}
	

	public void scenaNomeCanzone(String fxml,String changeUser,String nomeP,ArrayList<Canzone> catalogoSongs) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(root);  //carica la scena dopo login
		/*
		Parent root; 
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		root = loader.load();		
		NomeCanzone nomeCanzone= loader.getController();
		nomeCanzone.displayName(changeUser,nomeP,catalogoSongs);	
		stg.getScene().setRoot(root);
		stg.show();	*/
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
