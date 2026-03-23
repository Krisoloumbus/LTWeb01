package vn.iotstart.controllers.admin;
//src/main/java/vn/iotstart/controllers/admin/UserController.java
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstart.models.User;
import vn.iotstart.service.impl.UserServiceImpl;

@WebServlet("/admin/user/*")
public class UserController extends HttpServlet {
    private UserServiceImpl service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        if (path == null || "/".equals(path)) {
            req.setAttribute("users", service.getAll());
            req.getRequestDispatcher("/views/admin/users/list.jsp").forward(req, resp);

        } else if ("/add".equals(path)) {
            req.getRequestDispatcher("/views/admin/users/add.jsp").forward(req, resp);

        } else if (path.startsWith("/edit/")) {
            int id = Integer.parseInt(path.split("/")[2]);
            req.setAttribute("user", service.getById(id));
            req.getRequestDispatcher("/views/admin/users/edit.jsp").forward(req, resp);

        } else if (path.startsWith("/delete/")) {
            int id = Integer.parseInt(path.split("/")[2]);
            service.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/user/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        if ("/add".equals(path)) {
            User u = buildUser(req);
            service.register(u);

        } else if (path.startsWith("/edit/")) {
            int id = Integer.parseInt(path.split("/")[2]);
            User u = buildUser(req);
            u.setId(id);
            service.update(u);
        }

        resp.sendRedirect(req.getContextPath() + "/admin/user/");
    }

    private User buildUser(HttpServletRequest req) {
        User u = new User();
        u.setName(req.getParameter("name"));
        u.setPassword(req.getParameter("password"));
        u.setSeller("true".equals(req.getParameter("isSeller")));
        u.setAdmin("true".equals(req.getParameter("isAdmin")));
        return u;
    }
}