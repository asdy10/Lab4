package lab.dao;

import lab.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProductDAOFromTXT implements ProductDAO {

    Scanner sc;

    @Override
    public List<Product> getAll() {

        List<Product> productList = new ArrayList<>();
        {
            try {
                sc = new Scanner(new File("ProductDao.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        while (sc.hasNext()){
            String s = sc.nextLine();
            String [] split = s.split(",");

            int i=1;
            while(i<split.length){
                Product newProduct = new Product(split[0], Integer.valueOf(split[i++]), Integer.valueOf(split[i++]), Float.valueOf(split[i++]));
                productList.add(newProduct);
            }
        }
        return productList;
    }

    @Override
    public List<Product> getByID(int ID) {

        List<Product> productList = new ArrayList<>();

        {
            try {
                sc = new Scanner(new File("ProductDao.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(",");

            int i = 1;
            while (i < split.length) {
                if (Integer.valueOf(split[i + 1]) == ID) {
                    Product newProduct = new Product(split[0], Integer.valueOf(split[i++]), Integer.valueOf(split[i++]), Float.valueOf(split[i++]));
                    productList.add(newProduct);
                } else i += 3;
            }
        }
        return productList;
    }

    @Override
    public void create(Product product) {

        List<String> lines = new ArrayList<>();
        Scanner sc;


        try {
            sc = new Scanner(new InputStreamReader(new FileInputStream("C:\\Users\\Alexee_PC\\IdeaProjects\\Lab4\\src\\lab\\ProductDao.txt")));
            while (sc.hasNext())
                lines.add(sc.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.add(product.toString());
        System.out.println(lines.toString());
        try {
            StringBuilder str = new StringBuilder();
            FileWriter fw = new FileWriter("C:\\Users\\Alexee_PC\\IdeaProjects\\Lab4\\src\\lab\\ProductDao.txt");
            for(int i = 0; i<lines.size(); i++) {
                str.append(lines.get(i)).append("\r\n");

            }
            fw.write(str.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Product product) {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("ProductDao.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<String> linesIterator = lines.iterator();
        while (linesIterator.hasNext()){

            String [] split = linesIterator.next().split(",");
            if(split[0].equals(product.getName())){
                linesIterator.remove();
            }
        }


        try {
            Files.write(Paths.get("ProductDao.txt"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product product, int count) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("ProductDao.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i<lines.size(); i++) {
            String [] split = lines.get(i).split(",");
            if(split[0].equals(product.getName())){
                for(int j=1; j<split.length; j+=3 )
                    if (product.getMarketId() == Integer.valueOf(split[j])) {
                        split[j + 1] = Integer.valueOf(product.getCount() + count).toString();
                        String s = split.toString();
                        lines.set(i, s);
                        break;
                    }
            }
        }

        try {
            Files.write(Paths.get("ProductDao.txt"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
