//LTWeb01\src\main\java\vn\iotstart\controllers\admin\AdminHomeController.java

package vn.iotstart.controllers.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/home")
public class AdminHomeController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/views/admin/home.jsp")
           .forward(req, resp);
    }
}
