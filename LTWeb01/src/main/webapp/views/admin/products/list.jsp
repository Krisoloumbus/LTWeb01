<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.Product" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin-pages.css">

<%@ include file="/views/admin/common/header.jsp" %>

<div class="page-wrap">
    <div class="page-card">
        <h2 class="page-title">Danh sách sản phẩm</h2>

        <div class="action-row">
            <a class="btn-link btn-primary" href="${pageContext.request.contextPath}/admin/product/add">
                Thêm sản phẩm
            </a>
            <a class="btn-link btn-secondary" href="${pageContext.request.contextPath}/admin/home">
                Quay lại
            </a>
        </div>

        <form class="search-form" action="${pageContext.request.contextPath}/admin/product/search" method="get">
            <input type="text" name="keyword" placeholder="Tìm theo tên...">
            <button class="btn-submit btn-primary" type="submit">Search</button>
        </form>

        <div class="table-wrap">
            <table class="data-table">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Action</th>
                </tr>

                <%
                    List<Product> list = (List<Product>) request.getAttribute("products");
                    if (list != null) {
                        for (Product p : list) {
                %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getPrice() %></td>
                    <td>
                        <%
                            if (p.getImg() != null && !p.getImg().isEmpty()) {
                        %>
                            <img class="preview-img" src="<%=request.getContextPath()%>/images/<%=p.getImg()%>" alt="<%=p.getName()%>">
                        <%
                            } else {
                        %>
                            Không có ảnh
                        <%
                            }
                        %>
                    </td>
                    <td>
                        <a class="btn-link btn-warning"
                           href="${pageContext.request.contextPath}/admin/product/edit/<%=p.getId()%>">
                            Edit
                        </a>
                        <a class="btn-link btn-danger"
                           href="${pageContext.request.contextPath}/admin/product/delete/<%=p.getId()%>"
                           onclick="return confirm('Delete?')">
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