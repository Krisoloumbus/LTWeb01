<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-pages.css">

<%@ include file="/views/admin/common/header.jsp" %>

<div class="page-wrap">
    <div class="page-card">
        <h2 class="page-title">Danh sách Category</h2>

        <div class="action-row">
            <a href="${pageContext.request.contextPath}/admin/category/add"
               class="btn-link btn-primary">Thêm mới</a>

            <a href="${pageContext.request.contextPath}/admin/home"
               class="btn-link btn-secondary">Quay lại</a>
        </div>

        <form class="search-form" action="${pageContext.request.contextPath}/admin/category/search" method="get">
            <input type="text" name="keyword" placeholder="Nhập tên category...">
            <button class="btn-submit btn-primary" type="submit">Search</button>
        </form>

        <c:choose>
            <c:when test="${empty categories}">
                <div class="page-card">
                    <p>Chưa có category nào.</p>
                    <a href="${pageContext.request.contextPath}/admin/category/add"
                       class="btn-link btn-primary">Thêm ngay</a>
                </div>
            </c:when>

            <c:otherwise>
                <div class="table-wrap">
                    <table class="data-table">
                        <tr>
                            <th>ID</th>
                            <th>Tên Category</th>
                            <th>Icon</th>
                            <th>Hành động</th>
                        </tr>

                        <c:forEach var="category" items="${categories}">
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.name}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${not empty category.icon}">
                                            <img class="preview-img"
                                                 src="${pageContext.request.contextPath}/images/${category.icon}"
                                                 alt="${category.name}">
                                        </c:when>
                                        <c:otherwise>
                                            Không có ảnh
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/category/edit/${category.id}"
                                       class="btn-link btn-warning">Sửa</a>

                                    <a href="${pageContext.request.contextPath}/admin/category/delete/${category.id}"
                                       class="btn-link btn-danger"
                                       onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%@ include file="/views/admin/common/footer.jsp" %>