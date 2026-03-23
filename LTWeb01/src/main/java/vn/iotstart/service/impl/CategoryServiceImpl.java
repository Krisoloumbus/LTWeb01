package vn.iotstart.service.impl;

import java.io.File;
import java.util.List;

import vn.iotstart.dao.CategoryDAO;
import vn.iotstart.dao.impl.CategoryDAOImpl;
import vn.iotstart.models.Category;
import vn.iotstart.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDao = new CategoryDAOImpl();
    
    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }
    
    @Override
    public void delete(int id) {
        Category oldCategory = categoryDao.get(id);
        if (oldCategory != null && oldCategory.getIcon() != null) {
            // Xóa ảnh cũ
            String dir = "src/main/webapp/uploads";
            File file = new File(dir + "/" + oldCategory.getIcon());
            if (file.exists()) {
                file.delete();
            }
        }
        categoryDao.delete(id);
    }
    
    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }
    
    @Override
    public void edit(Category newCategory) {
        Category oldCategory = categoryDao.get(newCategory.getId());
        if (oldCategory != null) {
            oldCategory.setName(newCategory.getName());
            if (newCategory.getIcon() != null && !newCategory.getIcon().isEmpty()) {
                String dir = "/Users/tuankhanh/Documents/HCMUTE/HK2/LT-WEB/LTWeb01/uploads/";
                if (oldCategory.getIcon() != null) {
                    File file = new File(dir + "/" + oldCategory.getIcon());
                    if (file.exists()) file.delete();
                }
                oldCategory.setIcon(newCategory.getIcon());
            }
            categoryDao.edit(oldCategory);
        }
    }
    
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }
}
