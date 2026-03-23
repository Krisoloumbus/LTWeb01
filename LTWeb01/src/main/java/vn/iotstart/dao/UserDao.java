package vn.iotstart.dao;
//LTWeb01\src\main\java\vn\iotstart\dao\UserDao.java
import java.util.List;

import vn.iotstart.models.User;

public interface UserDao {
    User findByUsername(String name);
    void insert(User user);

    List<User> getAll();
    User getById(int id);
    void update(User user);
    void delete(int id);
}