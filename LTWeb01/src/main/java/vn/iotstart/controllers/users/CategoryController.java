package vn.iotstart.controllers.users;
//LTWeb01\src\main\java\vn\iotstart\controllers/users\CategoryController.java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstart.models.Category;
import vn.iotstart.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/*")  // ← Router chính!
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,    // 1MB
    maxFileSize = 1024 * 1024 * 10,     // 10MB
    maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class CategoryController extends HttpServlet {
    
    private CategoryServiceImpl service = new CategoryServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || "/".equals(pathInfo)) {
            listCategories(request, response);
        } else if ("/add".equals(pathInfo)) {
            addForm(request, response);
        } else if (pathInfo.startsWith("/edit/")) {
            String[] parts = pathInfo.split("/");
            int id = Integer.parseInt(parts[2]);
            editForm(request, response, id);
        } else if (pathInfo.startsWith("/delete/")) {
            String[] parts = pathInfo.split("/");
            int id = Integer.parseInt(parts[2]);
            deleteCategory(request, response, id);
        } else if (pathInfo.equals("/search")) {
            searchCategory(request, response);
        }else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String pathInfo = request.getPathInfo();
        if ("/add".equals(pathInfo)) {
            saveCategory(request, response);
        } else if (pathInfo != null && pathInfo.startsWith("/edit/")) {
            String[] parts = pathInfo.split("/");
            int id = Integer.parseInt(parts[2]);
            updateCategory(request, response, id);
        }
    }
    private void listCategories(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Category> categories = service.getAll();
        request.setAttribute("categories", categories);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/list-category.jsp");
        rd.forward(request, response);
    }
    
    private void addForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("category", new Category());
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/add-category.jsp");
        rd.forward(request, response);
    }
    private void saveCategory(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Category category = new Category();
        category.setName(request.getParameter("cateName"));
        
        Part filePart = request.getPart("file");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = uploadFile(filePart, request);
            category.setIcon(fileName);
        }
        
        service.insert(category);
        response.sendRedirect(request.getContextPath() + "/admin/category/");
    }
    
    private void editForm(HttpServletRequest request, HttpServletResponse response, int id) 
            throws ServletException, IOException {
        Category category = service.get(id);
        if (category != null) {
            request.setAttribute("category", category);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/edit-category.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/categories");
        }
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response, int id) 
            throws ServletException, IOException {
        Category category = service.get(id);
        if (category != null) {
            category.setName(request.getParameter("cateName"));
            
            Part filePart = request.getPart("file");
            if (filePart != null && filePart.getSize() > 0) {
                deleteOldFile(category.getIcon(), request);
                String fileName = uploadFile(filePart, request);
                category.setIcon(fileName);
            }
            
            service.edit(category);
        }
        response.sendRedirect(request.getContextPath() + "/admin/category/");
    }
    
    private void deleteCategory(HttpServletRequest request, HttpServletResponse response, int id) 
            throws ServletException, IOException {
        Category category = service.get(id);
        if (category != null) {
            deleteOldFile(category.getIcon(), request);
            service.delete(id);
        }
        response.sendRedirect(request.getContextPath() + "/admin/category/");
    }
    
    private String uploadFile(Part filePart, HttpServletRequest request) throws IOException {
        String originalName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String fileName = System.currentTimeMillis() + "_" + originalName;
        String uploadPath = "D:/Coding/HCMUTE_Web/LTWeb01/LTWeb01/uploads/";

        Path uploadDir = Paths.get(uploadPath);
        Files.createDirectories(uploadDir);
        Files.copy(filePart.getInputStream(), uploadDir.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        
        return fileName;
    }
    
    private void deleteOldFile(String fileName, HttpServletRequest request) {
        if (fileName != null && !fileName.isEmpty()) {
            try {
            	String uploadPath = "D:/Coding/HCMUTE_Web/LTWeb01/LTWeb01/uploads/";
                Path filePath = Paths.get(uploadPath, fileName);
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void searchCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        List<Category> list = service.search(keyword);
        request.setAttribute("categories", list);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category/list-category.jsp");
        rd.forward(request, response);
    }
    
}
