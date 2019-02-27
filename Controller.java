package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.security.util.Password;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField usernameTxt;
    @FXML
    private PasswordField passwordTxt;
    @FXML
    private Label alertLabel;

    HashMap<String, String> admins = new HashMap<>();
    static HashMap<String, String> customers = new HashMap<>();
    ArrayList<String> adminNames = new ArrayList<>();
    static ArrayList<String> customerNames = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        admins.put("admin1", "pass");
        admins.put("admin2", "pass2");


        customers.put("bob", "bob1");
        customers.put("alice", "alice2");


        for (String adminName : admins.keySet()) {

            adminNames.add(adminName);
        }
        for (String customerName : customers.keySet()){
            customerNames.add(customerName);
        }
    }



    @FXML
    public void loginUser(ActionEvent event) throws IOException {
        if (adminNames.contains(usernameTxt.getText())) {
            if (passwordTxt.getText().equals(admins.get(usernameTxt.getText()))){
//                ProductBridge.getDesiredView("adminView");
//                System.out.println("Hello " + usernameTxt.getText());
                ProductBridge bridge = new ProductBridge();
                ProductBridge.populateProducts();
                bridge.getDesiredView("adminView");
                ((Node) event.getSource()).getScene().getWindow().hide();
            }else{
//                System.out.println("Username or password is incorrect");
                alertLabel.setText("Username or password is incorrect");
                usernameTxt.clear();
                passwordTxt.clear();
            }
        }else if(customerNames.contains(usernameTxt.getText())){
            if (passwordTxt.getText().equals(customers.get(usernameTxt.getText()))){
                ProductBridge bridge = new ProductBridge();
                ProductBridge.populateProducts();
                bridge.getDesiredView("customerView");
                ((Node) event.getSource()).getScene().getWindow().hide();

            }else{
//                System.out.println("Username or password is incorrect");
                alertLabel.setText("Username or password is incorrect");
                usernameTxt.clear();
                passwordTxt.clear();
            }
        }
        else{
//            System.out.println("Username or password is incorrect");
            alertLabel.setText("Username or password is incorrect");
            usernameTxt.clear();
            passwordTxt.clear();
        }
    }

    @FXML
    public void registerUser(ActionEvent event) throws IOException{
        if(!usernameTxt.getText().isEmpty() && !passwordTxt.getText().isEmpty()){
            customers.put(usernameTxt.getText(), passwordTxt.getText());

            for (String customerName : customers.keySet()){
                customerNames.add(customerName);
            }
        }

        System.out.println(customers);
    }
}
