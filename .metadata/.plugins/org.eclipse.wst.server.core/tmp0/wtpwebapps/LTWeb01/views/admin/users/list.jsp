<%-- src/main/webapp/views/admin/users/list.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.User" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-pages.css">

<%@ include file="/views/admin/common/header.jsp" %>

<div class="page-wrap">
    <div class="page-card">
        <h2 class="page-title">Quản lý User</h2>

        <div class="action-row">
            <a class="btn-link btn-primary" href="${pageContext.request.contextPath}/admin/user/add">
                Thêm user
            </a>
            <a class="btn-link btn-secondary" href="${pageContext.request.contextPath}/admin/home">
                Về Dashboard
            </a>
        </div>

        <div class="table-wrap">
            <table class="data-table">
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
                        <a class="btn-link btn-warning"
                           href="${pageContext.request.contextPath}/admin/user/edit/<%=u.getId()%>">
                            Edit
                        </a>
                        <a class="btn-link btn-danger"
                           href="${pageContext.request.contextPath}/admin/user/delete/<%=u.getId()%>"
                           onclick="return confirm('Xóa user này?')">
                            Delete
                        </a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
    </div>
</div>

<%@ include file="/views/admin/common/footer.jsp" %>