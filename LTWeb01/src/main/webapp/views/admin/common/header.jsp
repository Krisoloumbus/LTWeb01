<%@ page contentType="text/html;charset=UTF-8" %>
<%-- LTWeb01\src\main\webapp\views\admin\common\header.jsp --%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-layout.css">

<div class="admin-header">
    <h3 class="admin-header__title">Admin Panel</h3>
    <a class="admin-header__logout" href="${pageContext.request.contextPath}/auth?action=logout">
        Đăng xuất
    </a>
</div>