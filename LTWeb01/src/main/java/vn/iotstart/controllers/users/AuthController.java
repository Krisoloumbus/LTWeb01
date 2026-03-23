//LTWeb01\src\main\java\vn\iotstart\controllers/users\AuthController.java

package vn.iotstart.controllers.users;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstart.models.User;
import vn.iotstart.service.UserService;
import vn.iotstart.service.impl.UserServiceImpl;
import vn.iotstart.utils.SessionUtil;
public class AuthController extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("login".equals(action)) {
            req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);

        } else if ("register".equals(action)) {
            req.getRequestDispatcher("/views/auth/register.jsp").forward(req, resp);

        } else if ("logout".equals(action)) {
            SessionUtil.remove(req, "account");
            resp.sendRedirect(req.getContextPath() + "/auth?action=login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException {

        String action = req.getParameter("action");

        if ("login".equals(action)) {
            handleLogin(req, resp);

        } else if ("register".equals(action)) {
            handleRegister(req, resp);
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String name = req.getParameter("name");
        String pass = req.getParameter("password");

        User u = service.login(name, pass);

        if (u != null) {
            SessionUtil.set(req, "account", u);

            if (u.isAdmin()) {
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            req.setAttribute("error", "Sai tài khoản hoặc mật khẩu");
            req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
        }
    }

    private void handleRegister(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        User u = new User();
        u.setName(req.getParameter("name"));
        u.setPassword(req.getParameter("password"));
        u.setSeller(false);
        u.setAdmin(false);

        service.register(u);

        resp.sendRedirect(req.getContextPath() + "/auth?action=login");
    }
}
