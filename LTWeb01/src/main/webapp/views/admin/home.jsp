<%-- LTWeb01\src\main\webapp\views\admin\home.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/views/admin/common/header.jsp" %>

<div class="admin-page">
    <main class="admin-main">
        <div class="admin-container">
            <div class="admin-card">
                <h2 class="admin-title">Trang Admin Dashboard</h2>
                <p class="admin-desc">Trang Quản Trị Của ADMIN</p>

                <ul class="admin-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/category">Quản lý Category</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/product">Quản lý Product</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/user/">Quản lý Users</a>
                    </li>
                </ul>
            </div>
        </div>
    </main>

    <%@ include file="/views/admin/common/footer.jsp" %>
</div>