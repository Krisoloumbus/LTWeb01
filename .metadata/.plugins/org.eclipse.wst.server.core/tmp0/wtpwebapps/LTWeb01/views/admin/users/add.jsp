<%-- src/main/webapp/views/admin/users/add.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-pages.css">

<%@ include file="/views/admin/common/header.jsp" %>

<div class="form-card">
    <h2 class="page-title">Thêm User</h2>

    <form action="${pageContext.request.contextPath}/admin/user/add" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name">
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="text" name="password">
        </div>

        <div class="form-group">
            <label>Is Seller</label>
            <select name="isSeller">
                <option value="false">False</option>
                <option value="true">True</option>
            </select>
        </div>

        <div class="form-group">
            <label>Is Admin</label>
            <select name="isAdmin">
                <option value="false">False</option>
                <option value="true">True</option>
            </select>
        </div>

        <div class="action-row">
            <button class="btn-submit btn-primary" type="submit">Save</button>
            <a class="btn-link btn-secondary" href="${pageContext.request.contextPath}/admin/user/">
                Back
            </a>
        </div>
    </form>
</div>

<%@ include file="/views/admin/common/footer.jsp" %>