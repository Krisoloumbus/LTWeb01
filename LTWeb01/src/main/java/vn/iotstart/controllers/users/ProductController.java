package vn.iotstart.controllers.users;

//LTWeb01\src\main\java\vn\iotstart\controllers/users\ProductController.java
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstart.models.Product;
import vn.iotstart.service.impl.CategoryServiceImpl;
import vn.iotstart.service.impl.ProductServiceImpl;

@WebServlet("/admin/product/*")
@MultipartConfig
public class ProductController extends HttpServlet {
	private CategoryServiceImpl categoryService = new CategoryServiceImpl();
    private ProductServiceImpl service = new ProductServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        if (path == null || "/".equals(path)) {
            req.setAttribute("products", service.getAll());
            req.getRequestDispatcher("/views/admin/products/list.jsp").forward(req, resp);

        } else if (path.equals("/add")) {
            req.setAttribute("categories", categoryService.getAll()); 
            req.getRequestDispatcher("/views/admin/products/add.jsp").forward(req, resp);
        } else if (path.startsWith("/edit/")) {
            long id = Long.parseLong(path.split("/")[2]);
            req.setAttribute("product", service.get(id));
            req.setAttribute("categories", categoryService.getAll());
            req.getRequestDispatcher("/views/admin/products/edit.jsp").forward(req, resp);
        }else if (path.startsWith("/delete/")) {
            long id = Long.parseLong(path.split("/")[2]);
            service.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/product/");

        } else if (path.startsWith("/search")) {
            String keyword = req.getParameter("keyword");
            req.setAttribute("products", service.search(keyword));
            req.getRequestDispatcher("/views/admin/products/list.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        try {
            if (path.equals("/add")) {
                Product p = buildProduct(req);
                service.insert(p);

            } else if (path.startsWith("/edit/")) {
                long id = Long.parseLong(path.split("/")[2]);
                Product p = buildProduct(req);
                p.setId(id);
                service.edit(p);
            }

            resp.sendRedirect(req.getContextPath() + "/admin/product/");

        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.setAttribute("categories", categoryService.getAll());

            if (path.startsWith("/edit/")) {
                req.getRequestDispatcher("/views/admin/products/edit.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/views/admin/products/add.jsp").forward(req, resp);
            }
        }
    }

    private Product buildProduct(HttpServletRequest req) throws IOException, ServletException {
        Product p = new Product();

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String priceStr = req.getParameter("price");
        String categoryIdStr = req.getParameter("category_id");
        String amountStr = req.getParameter("amount");
        String stockStr = req.getParameter("stock");

        if (priceStr == null || priceStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Price không được để trống");
        }
        if (categoryIdStr == null || categoryIdStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Category không được để trống");
        }
        if (amountStr == null || amountStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Amount không được để trống");
        }
        if (stockStr == null || stockStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Stock không được để trống");
        }

        p.setName(name);
        p.setDescription(description);
        p.setPrice(Double.parseDouble(priceStr.trim()));
        p.setCategoryId(Long.parseLong(categoryIdStr.trim()));
        p.setSellerId(2);
        p.setAmount(Integer.parseInt(amountStr.trim()));
        p.setStock(Integer.parseInt(stockStr.trim()));

        Part file = req.getPart("file");
        if (file != null && file.getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + file.getSubmittedFileName();
            file.write("D:/Coding/HCMUTE_Web/LTWeb01/LTWeb01/uploads/" + fileName);
            p.setImg(fileName);
        }

        return p;
    }
}
