package vn.iotstart.service;
//LTWeb01\src\main\java\vn\iotstart\service\UserService.java

import java.util.List;

import vn.iotstart.models.User;

public interface UserService {
    User login(String name, String password);
    void register(User user);

    List<User> getAll();
    User getById(int id);
    void update(User user);
    void delete(int id);
}