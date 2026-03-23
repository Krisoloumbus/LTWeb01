package vn.iotstart.controllers.users;

//LTWeb01\src\main\java\vn\iotstart\controllers/users\TestDBController.java
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstart.utils.DBConnection;

@WebServlet("/test-db")
public class TestDBController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                out.println("<h2 style='color:green'>Kết nối SQL Server thành công</h2>");
            } else {
                out.println("<h2 style='color:red'>Kết nối SQL Server thất bại</h2>");
            }
        } catch (Exception e) {
            out.println("<h2 style='color:red'>Lỗi kết nối SQL Server</h2>");
            out.println("<pre>" + e.getMessage() + "</pre>");
        }
    }
}