<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.Product" %>

<h2>Danh sách sản phẩm</h2>

<form action="${pageContext.request.contextPath}/admin/product/search" method="get">
    <input type="text" name="keyword" placeholder="Tìm theo tên...">
    <button type="submit">Search</button>
</form>

<a href="${pageContext.request.contextPath}/admin/product/add">+ Thêm sản phẩm</a>
<a href="${pageContext.request.contextPath}/admin/home" class="btn btn-primary">Quay lại</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Image</th>
        <th>Action</th>
    </tr>

    <%
        List<Product> list = (List<Product>) request.getAttribute("products");
        if (list != null) {
            for (Product p : list) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td>
            <img src="<%=request.getContextPath()%>/images/<%=p.getImg()%>" width="80">
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/admin/product/edit/<%=p.getId()%>">Edit</a> |
            <a href="${pageContext.request.contextPath}/admin/product/delete/<%=p.getId()%>" onclick="return confirm('Delete?')">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>