<%-- src/main/webapp/views/admin/users/edit.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="vn.iotstart.models.User" %>

<%
    User u = (User) request.getAttribute("user");
%>

<h2>Sửa User</h2>

<form action="${pageContext.request.contextPath}/admin/user/edit/<%=u.getId()%>" method="post">
    Name: <input type="text" name="name" value="<%=u.getName()%>"><br><br>

    Password: <input type="text" name="password" value="<%=u.getPassword()%>"><br><br>

    Is Seller:
    <select name="isSeller">
        <option value="false" <%= !u.isSeller() ? "selected" : "" %>>False</option>
        <option value="true" <%= u.isSeller() ? "selected" : "" %>>True</option>
    </select>
    <br><br>

    Is Admin:
    <select name="isAdmin">
        <option value="false" <%= !u.isAdmin() ? "selected" : "" %>>False</option>
        <option value="true" <%= u.isAdmin() ? "selected" : "" %>>True</option>
    </select>
    <br><br>

    <button type="submit">Update</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/admin/user/">Back</a>