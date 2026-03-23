package vn.iotstart.dao.impl;
//LTWeb01\src\main\java\vn\iotstart\dao\impl\UserDAOImpl.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstart.dao.UserDao;
import vn.iotstart.models.User;
import vn.iotstart.utils.DBConnection;

public class UserDAOImpl implements UserDao {

    @Override
    public User findByUsername(String name) {
        String sql = "SELECT * FROM users WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = mapUser(rs);
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users(name,password,isSeller,isAdmin) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isSeller());
            ps.setBoolean(4, user.isAdmin());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY id ASC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapUser(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapUser(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, password = ?, isSeller = ?, isAdmin = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isSeller());
            ps.setBoolean(4, user.isAdmin());
            ps.setInt(5, user.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private User mapUser(ResultSet rs) throws Exception {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setPassword(rs.getString("password"));
        u.setSeller(rs.getBoolean("isSeller"));
        u.setAdmin(rs.getBoolean("isAdmin"));
        return u;
    }
}