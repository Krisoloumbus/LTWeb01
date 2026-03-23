<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="vn.iotstart.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.Category" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-pages.css">

<%
    Product p = (Product) request.getAttribute("product");
%>

<%@ include file="/views/admin/common/header.jsp" %>

<div class="form-card">
    <h2 class="page-title">Sửa sản phẩm</h2>

    <form action="${pageContext.request.contextPath}/admin/product/edit/<%=p.getId()%>" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name" value="<%=p.getName()%>">
        </div>

        <div class="form-group">
            <label>Description</label>
            <textarea name="description"><%=p.getDescription()%></textarea>
        </div>

        <div class="form-group">
            <label>Price</label>
            <input type="text" name="price" value="<%=p.getPrice()%>">
        </div>

        <div class="form-group">
            <label>Category</label>
            <select name="category_id">
                <%
                    List<Category> categories = (List<Category>) request.getAttribute("categories");
                    if (categories != null) {
                        for (Category c : categories) {
                            boolean selected = c.getId() == p.getCategoryId();
                %>
                    <option value="<%=c.getId()%>" <%= selected ? "selected" : "" %>>
                        <%=c.getName()%>
                    </option>
                <%
                        }
                    }
                %>
            </select>
        </div>

        <div class="form-group">
            <label>Amount</label>
            <input type="text" name="amount" value="<%=p.getAmount()%>">
        </div>

        <div class="form-group">
            <label>Stock</label>
            <input type="text" name="stock" value="<%=p.getStock()%>">
        </div>

        <div class="form-group">
            <label>Ảnh hiện tại</label>
            <%
                if (p.getImg() != null && !p.getImg().isEmpty()) {
            %>
                <img class="current-img" src="<%=request.getContextPath()%>/images/<%=p.getImg()%>" alt="<%=p.getName()%>">
            <%
                } else {
            %>
                <p>Không có ảnh</p>
            <%
                }
            %>
        </div>

        <div class="form-group">
            <label>Image mới</label>
            <input type="file" name="file" accept="image/*">
        </div>

        <div class="action-row">
            <button class="btn-submit btn-warning" type="submit">Update</button>
            <a class="btn-link btn-secondary" href="${pageContext.request.contextPath}/admin/product/">Back</a>
        </div>
    </form>
</div>

<%@ include file="/views/admin/common/footer.jsp" %>