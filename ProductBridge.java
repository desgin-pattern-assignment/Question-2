package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProductBridge {
        static ArrayList<Product> products = new ArrayList<>();

        public static void populateProducts(){
            products.add(new Product("Shoes", 100));
            products.add(new Product("Jackets", 800));
            products.add(new Product("Shirts", 300));
        }

        public static ArrayList<Product> getProducts(){
            return products;
        }

        public static void addProduct(Product prod){
            products.add(prod);
        }


        public void getDesiredView(String type) throws IOException {
            if (type.equals("adminView")) {
//                ExecutiveView ev = new ExecutiveView(products);
//                System.out.println(ev.getExecutiveProducts());
                Parent parent = FXMLLoader.load(getClass().getResource("ExecutiveView.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Products");
                stage.show();
            }
            if(type.equals("customerView")){
                Parent parent = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Products");
                stage.show();
            }
    }
}
