package vn.iotstart.filters;

import java.io.IOException;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstart.utils.SessionUtil;

public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Object user = SessionUtil.get(req, "account");

        String uri = req.getRequestURI();
        String context = req.getContextPath();
        String path = uri.substring(context.length());

        DispatcherType type = req.getDispatcherType();

        if (type != DispatcherType.REQUEST) {
            chain.doFilter(request, response);
            return;
        }


if (path.startsWith("/auth") 
    || path.startsWith("/assets") 
    || path.startsWith("/views")) {
    chain.doFilter(request, response);
    return;
}
        
        if (SessionUtil.get(req, "account") == null) {
            resp.sendRedirect(context + "/auth?action=login");
            return;
        } else {
            chain.doFilter(request, response);
        }
        
    }
}