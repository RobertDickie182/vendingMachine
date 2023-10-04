package Machine;

import Products.Product;

import java.util.ArrayList;

public class Drawer {

    private DrawerCode code;

    private double price;

    private ArrayList<Product> items;

    public Drawer(DrawerCode code, double price) {
        this.code = code;
        this.price = price;
        this.items = new ArrayList<>();
    }

    public DrawerCode getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public void addItem(Product product){
        this.items.add(product);
    }

    public int itemCount(){
        return this.items.size();
    }


}
