package vn.iotstart.controllers.users;

//LTWeb01\src\main\java\vn\iotstart\controllers/users\DownloadImageController.java

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstart.utils.Constant;

@WebServlet(urlPatterns = "/image")
public class DownloadImageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        String fileName = req.getParameter("fname");

        File file = new File(Constant.DIR + "/" + fileName);

        if (file.exists()) {

            FileInputStream fis = new FileInputStream(file);
            OutputStream os = resp.getOutputStream();

            resp.setContentType("image/jpeg");

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            fis.close();
            os.close();
        }
    }
}