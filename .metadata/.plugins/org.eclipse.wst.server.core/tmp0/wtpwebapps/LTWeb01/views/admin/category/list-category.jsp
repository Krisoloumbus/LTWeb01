<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Category</title>
    <style>
        table { border-collapse: collapse; width: 100%; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f2f2f2; font-weight: bold; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        tr:hover { background-color: #f5f5f5; }
        .btn { padding: 8px 16px; text-decoration: none; border-radius: 4px; margin-right: 5px; }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-warning { background-color: #ffc107; color: black; }
        .btn-danger { background-color: #dc3545; color: white; }
        img { max-width: 60px; max-height: 60px; }
        .no-data { text-align: center; padding: 50px; color: #666; }
    </style>
</head>
<body>
    <div style="margin: 20px;">
        <h1>Danh sách Category</h1>
        <a href="${pageContext.request.contextPath}/admin/category/add" 
           class="btn btn-primary">Thêm mới</a>
        <a href="${pageContext.request.contextPath}/admin/home"
            class="btn btn-primary">Quay lại</a>

		   <form action="${pageContext.request.contextPath}/admin/category/search" method="get">
		       <input type="text" name="keyword" placeholder="Nhập tên category...">
		       <button type="submit">Search</button>
		   </form>
        <c:choose>
            <c:when test="${empty categories}">
                <div class="no-data">
                    <h3>Chưa có category nào</h3>
                    <p><a href="${pageContext.request.contextPath}/categories/add">Thêm ngay!</a></p>
                </div>
            </c:when>
            <c:otherwise>
                <table>
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
								<c:if test="${not empty category.icon}">
								    <img src="${pageContext.request.contextPath}/images/${category.icon}" 
								         alt="${category.name}" style="width:100px;height:100px;">
								</c:if>
                                <c:if test="${empty category.icon}">
                                    Không có ảnh
                                </c:if>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/category/edit/${category.id}" 
                                   class="btn btn-warning">Sửa</a>
                                <a href="${pageContext.request.contextPath}/admin/category/delete/${category.id}" 
                                   class="btn btn-danger"
                                   onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
