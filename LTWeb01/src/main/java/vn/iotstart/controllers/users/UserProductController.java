//src/main/java/vn/iotstart/controllers/users/UserProductController.java
package vn.iotstart.controllers.users;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstart.service.impl.ProductServiceImpl;

@WebServlet("/product")
public class UserProductController extends HttpServlet {
    private ProductServiceImpl service = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("products", service.getAll());
        req.getRequestDispatcher("/views/users/products/list.jsp").forward(req, resp);
    }
}