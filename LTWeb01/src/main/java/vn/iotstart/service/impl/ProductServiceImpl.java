package vn.iotstart.service.impl;

import java.io.File;
import java.util.List;

import vn.iotstart.dao.ProductDAO;
import vn.iotstart.dao.impl.ProductDAOImpl;
import vn.iotstart.models.Product;
import vn.iotstart.service.ProductService;

public class ProductServiceImpl implements ProductService {

    private ProductDAO dao = new ProductDAOImpl();

    @Override
    public void insert(Product p) {
        dao.insert(p);
    }

    @Override
    public void edit(Product p) {
        dao.edit(p);
    }

    @Override
    public void delete(long id) {
        Product old = dao.get(id);
        if (old != null && old.getImg() != null) {
            File f = new File("/uploads/" + old.getImg());
            if (f.exists()) f.delete();
        }
        dao.delete(id);
    }

    @Override
    public Product get(long id) {
        return dao.get(id);
    }

    @Override
    public List<Product> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Product> search(String keyword) {
        return dao.search(keyword);
    }
}