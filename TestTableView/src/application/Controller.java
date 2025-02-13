package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{

	@FXML
	public TableView<Prodotto> tableview;
	@FXML
	public TableColumn<Prodotto, String> colName;
	@FXML
	public TableColumn<Prodotto, Double> colPrice;
	@FXML
	public TableColumn<Prodotto, Integer> colQuantity;
	
	public void initialize(URL location,ResourceBundle resources) {
		
		colName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
		colPrice.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));
		colQuantity.setCellValueFactory(new PropertyValueFactory<>("ProductQuantity"));
		tableview.setItems(observableList);
		
	}

	
	ObservableList<Prodotto> observableList = FXCollections.observableArrayList(
			new Prodotto("nome1",24.1,0),
			new Prodotto("nome2",24.1,0),
			new Prodotto("nome3",24.1,0)
	);
	
	
}
