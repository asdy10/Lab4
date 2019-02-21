package lab;

import lab.dao.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Product product = new Product("test");
        float f = (float) 50.1;
        product.setCost(f);
        product.setCount(10);
        product.setMarket(1);
        ProductDAOFromTXT test = new ProductDAOFromTXT();
        test.create(product);
    }
}

