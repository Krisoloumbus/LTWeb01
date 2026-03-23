package vn.iotstart.service.impl;
//LTWeb01\src\main\java\vn\iotstart\service\impl\UserServiceImpl.java
import java.util.List;
import vn.iotstart.dao.UserDao;
import vn.iotstart.dao.impl.UserDAOImpl;
import vn.iotstart.models.User;
import vn.iotstart.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDAO = new UserDAOImpl();

    @Override
    public User login(String name, String password) {
        User u = userDAO.findByUsername(name);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    @Override
    public void register(User user) {
        userDAO.insert(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}