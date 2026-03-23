package vn.iotstart.dao;
import java.util.List;

import vn.iotstart.models.Category;

public interface CategoryDAO {
	void insert(Category category);
	void edit(Category category);
	void delete(int id);
	Category get(int id);
	List<Category> getAll();
	List<Category> search(String keyword);
}
