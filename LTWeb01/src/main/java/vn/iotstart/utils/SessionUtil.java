package vn.iotstart.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {
	public static void set(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    public static Object get(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        return session != null ? session.getAttribute(key) : null;
    }

    public static void remove(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        session.removeAttribute(key);
    }
}
