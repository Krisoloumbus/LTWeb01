<%-- src/main/webapp/views/admin/users/add.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>

<h2>Thêm User</h2>

<form action="${pageContext.request.contextPath}/admin/user/add" method="post">
    Name: <input type="text" name="name"><br><br>

    Password: <input type="text" name="password"><br><br>

    Is Seller:
    <select name="isSeller">
        <option value="false">False</option>
        <option value="true">True</option>
    </select>
    <br><br>

    Is Admin:
    <select name="isAdmin">
        <option value="false">False</option>
        <option value="true">True</option>
    </select>
    <br><br>

    <button type="submit">Save</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/admin/user/">Back</a>