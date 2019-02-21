package lab.dao;
import lab.bll.*;
import lab.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    void create(Product product);
    void delete(Product product);
    void edit(Product product, int count);

    List<Product> getByID(int ID);
}
