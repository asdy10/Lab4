package lab;

import lab.dao.*;
import lab.dao.ProductDAO;

public class ProductService {

    private ProductDAO productDAO;

    ProductService(ProductDAO dao) {
        productDAO = dao;
    }

}
