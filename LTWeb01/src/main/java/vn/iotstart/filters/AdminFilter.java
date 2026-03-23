package vn.iotstart.filters;

import vn.iotstart.models.User;
import vn.iotstart.utils.SessionUtil;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        User u = (User) SessionUtil.get(req, "account");

        if (u != null && u.isAdmin()) {
            chain.doFilter(request, response);
        } else {
        	resp.sendRedirect(req.getContextPath() + "/auth?action=login");
        }
    }
}