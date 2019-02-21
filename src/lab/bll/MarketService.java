package lab.bll;

import lab.dao.MarketDAOFromDB;
import lab.dao.MarketDAOFromTXT;
import lab.dao.ProductDAOFromDB;
import lab.dao.ProductDAOFromTXT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarketService {
        private Scanner sc;
        MarketService(){
            {
                try {
                    sc = new Scanner(new File("ProductDao.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            int i = sc.nextInt();
            if(i==1){
                MarketDAOFromTXT reader = new MarketDAOFromTXT();
            }
            else{
                MarketDAOFromDB reader = new MarketDAOFromDB();
            }
        }
}

