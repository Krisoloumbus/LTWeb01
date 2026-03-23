<%-- src/main/webapp/views/admin/users/list.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.User" %>

<h2>Quản lý User</h2>

<a href="${pageContext.request.contextPath}/admin/user/add">Thêm user</a>
<a href="${pageContext.request.contextPath}/admin/home" class="btn btn-primary">Quay lại</a>

<br><br>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Seller</th>
        <th>Admin</th>
        <th>Action</th>
    </tr>

    <%
        List<User> users = (List<User>) request.getAttribute("users");
        if (users != null) {
            for (User u : users) {
    %>
    <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getName() %></td>
        <td><%= u.getPassword() %></td>
        <td><%= u.isSeller() %></td>
        <td><%= u.isAdmin() %></td>
        <td>
            <a href="${pageContext.request.contextPath}/admin/user/edit/<%=u.getId()%>">Edit</a>
            |
            <a href="${pageContext.request.contextPath}/admin/user/delete/<%=u.getId()%>"
               onclick="return confirm('Xóa user này?')">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>