package vn.iotstart.service;

import java.util.List;
import vn.iotstart.models.Product;

public interface ProductService {
    void insert(Product p);
    void edit(Product p);
    void delete(long id);
    Product get(long id);
    List<Product> getAll();
    List<Product> search(String keyword);
}