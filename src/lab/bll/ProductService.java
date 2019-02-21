package lab.bll;

import lab.dao.ProductDAOFromDB;
import lab.dao.ProductDAOFromTXT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductService {
    private Scanner sc;
    ProductService(){
        {
            try {
                sc = new Scanner(new File("ProductDao.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        int i = sc.nextInt();
        if(i==1){
            ProductDAOFromTXT reader = new ProductDAOFromTXT();
        }
        else{
            ProductDAOFromDB reader = new ProductDAOFromDB();
        }
    }
}
