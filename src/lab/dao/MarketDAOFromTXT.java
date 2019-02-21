package lab.dao;

import lab.Market;
import lab.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketDAOFromTXT implements MarketDAO{
    Scanner sc;
    List<Market> marketList = new ArrayList();
    @Override
    public List<Market> getAll() {
        {
            try {
                sc = new Scanner(new File("MarketDao.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        while (sc.hasNext()){
            String s = sc.nextLine();
            String [] split = s.split(",");
            Market newMarket = new Market(Integer.valueOf(split[0]), split[1]);
            marketList.add(newMarket);
            }
        return marketList;
    }

    @Override
    public Market getByID(int ID) {
        {
            try {
                sc = new Scanner(new File("MarketDao.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        while (sc.hasNext()){
            String s = sc.nextLine();
            String [] split = s.split(",");
            if(Integer.valueOf(split[0])==ID) {
                Market newMarket = new Market(Integer.valueOf(split[0]), split[1]);
                return newMarket;
            }
        }
        return null;
    }

    @Override
    public void create(Market market) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("MarketDao.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.add(market.toString());
        try {
            Files.write(Paths.get("MarketDao.txt"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Market market) {

    }

    @Override
    public void edit(long ID, Market market) {

    }
}
