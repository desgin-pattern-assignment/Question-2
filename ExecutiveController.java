package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ExecutiveController implements Initializable {
    @FXML
    private TableView<Product> executiveTable;
    @FXML
    private TableColumn<Product, String> name;
    @FXML
    private TableColumn<Product, Integer> units;

    public ObservableList<Product> productList = FXCollections.observableArrayList(
            ProductBridge.getProducts()
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        units.setCellValueFactory(new PropertyValueFactory<Product, Integer>("shippedUnits"));
        executiveTable.setItems(productList);
    }
}
