package vn.iotstart.dao.impl;

import java.sql.*;
import java.util.*;
import vn.iotstart.dao.ProductDAO;
import vn.iotstart.models.Product;
import vn.iotstart.utils.DBConnection;

public class ProductDAOImpl extends DBConnection implements ProductDAO {

    @Override
    public void insert(Product p) {
        String sql = "INSERT INTO products(name, description, price, img, category_id, seller_id, amount, stock) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getImg());
            ps.setLong(5, p.getCategoryId());
            ps.setLong(6, p.getSellerId());
            ps.setInt(7, p.getAmount());
            ps.setInt(8, p.getStock());

            ps.executeUpdate();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product p) {
        String sql = "UPDATE products SET name=?, description=?, price=?, img=?, category_id=?, seller_id=?, amount=?, stock=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getImg());
            ps.setLong(5, p.getCategoryId());
            ps.setLong(6, p.getSellerId());
            ps.setInt(7, p.getAmount());
            ps.setInt(8, p.getStock());
            ps.setLong(9, p.getId());

            ps.executeUpdate();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM products WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product get(long id) {
        String sql = "SELECT * FROM products WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setImg(rs.getString("img"));
                p.setCategoryId(rs.getLong("category_id"));
                p.setSellerId(rs.getLong("seller_id"));
                p.setAmount(rs.getInt("amount"));
                p.setStock(rs.getInt("stock"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setImg(rs.getString("img"));
                p.setCategoryId(rs.getLong("category_id"));
                p.setSellerId(rs.getLong("seller_id"));
                p.setAmount(rs.getInt("amount"));
                p.setStock(rs.getInt("stock"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setImg(rs.getString("img"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}