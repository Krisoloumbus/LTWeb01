<%-- LTWeb01\src\main\webapp\views\admin\home.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>

<h2>Trang Admin Dashboard</h2>

<p>Trang Quản Trị Của ADMIN</p>

<ul>
    <li><a href="${pageContext.request.contextPath}/admin/category">Quản lý Category</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/product">Quản lý Product</a></li>
    <li><a href="${pageContext.request.contextPath}/admin/user/">Quản lý Users</a></li>
</ul>