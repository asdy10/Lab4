package lab;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private String  name;
    private String address;
    private int id;
    private List<Product> products = new ArrayList<>();

    public Market(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "," + name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addProduct(Product newProduct){ products.add(newProduct); }

}
