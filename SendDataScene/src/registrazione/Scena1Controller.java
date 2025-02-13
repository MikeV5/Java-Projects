package registrazione;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scena1Controller {
	
	
	@FXML
	 TextField nameTextField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void login(ActionEvent event) throws IOException {
		
		String username = nameTextField.getText();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("scena2.fxml"));
		root = loader.load();
		
		Scena2Controller scena2Controller = loader.getController();
		scena2Controller.displayName(username);
		
		//root = FXMLLoader.load(getClass().getResource("scena2.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);		
		stage.setScene(scene);
		stage.show();
	}
	
	

}
