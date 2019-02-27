package sample;

public class Product {
    private String productName;
    private int shippedUnits;

    public Product(String name, int units){
        this.productName = name;
        this.shippedUnits = units;
    }

    public String getProductName() {
        return productName;
    }

    public int getShippedUnits() {
        return shippedUnits;
    }

    @Override
    public String toString() {
        return this.productName + " " + this.shippedUnits;
    }
}
