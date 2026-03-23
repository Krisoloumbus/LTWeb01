<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user-layout.css">

<div class="user-header">
    <h3 class="user-header__title">User Panel</h3>

    <div class="user-header__nav">
        <a class="user-header__link" href="${pageContext.request.contextPath}/home">Home</a>
        <a class="user-header__link" href="${pageContext.request.contextPath}/product">Product</a>
        <a class="user-header__link" href="${pageContext.request.contextPath}/auth?action=logout">Đăng xuất</a>
    </div>
</div>