package vn.iotstart.controllers.users;

//LTWeb01\src\main\java\vn\iotstart\controllers/users\ImageServlet.java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
    
    private static final String UPLOAD_PATH = "D:/Coding/HCMUTE_Web/LTWeb01/LTWeb01/uploads/";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        if (pathInfo != null && pathInfo.startsWith("/")) {
            String fileName = pathInfo.substring(1);
            Path filePath = Paths.get(UPLOAD_PATH, fileName);

            if (Files.exists(filePath)) {
                String mimeType = getServletContext().getMimeType(fileName);
                response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
                Files.copy(filePath, response.getOutputStream());
                return;
            }
        }

        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}