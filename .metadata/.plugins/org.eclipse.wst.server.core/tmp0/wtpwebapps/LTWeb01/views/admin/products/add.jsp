<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.Category" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-pages.css">

<%@ include file="/views/admin/common/header.jsp" %>

<div class="form-card">
    <h2 class="page-title">Thêm sản phẩm</h2>

    <form action="${pageContext.request.contextPath}/admin/product/add" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name">
        </div>

        <div class="form-group">
            <label>Description</label>
            <textarea name="description"></textarea>
        </div>

        <div class="form-group">
            <label>Price</label>
            <input type="text" name="price">
        </div>

        <div class="form-group">
            <label>Category</label>
            <select name="category_id">
                <%
                    List<Category> categories = (List<Category>) request.getAttribute("categories");
                    if (categories != null) {
                        for (Category c : categories) {
                %>
                    <option value="<%=c.getId()%>"><%=c.getName()%></option>
                <%
                        }
                    }
                %>
            </select>
        </div>

        <div class="form-group">
            <label>Amount</label>
            <input type="text" name="amount">
        </div>

        <div class="form-group">
            <label>Stock</label>
            <input type="text" name="stock">
        </div>

        <div class="form-group">
            <label>Image</label>
            <input type="file" name="file" accept="image/*">
        </div>

        <div class="action-row">
            <button class="btn-submit btn-primary" type="submit">Save</button>
            <a class="btn-link btn-secondary" href="${pageContext.request.contextPath}/admin/product/">Back</a>
        </div>
    </form>
</div>

<%@ include file="/views/admin/common/footer.jsp" %>