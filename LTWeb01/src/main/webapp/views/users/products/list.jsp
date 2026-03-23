<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.Product" %>

<%@ include file="/views/users/common/header.jsp" %>

<div class="user-page">
    <main class="user-main">
        <div class="user-container">
            <div class="user-card">
                <h2 class="user-title">Danh sách sản phẩm</h2>

                <div class="user-table-wrap">
                    <table class="user-table">
                        <tr>
                            <th>ID</th>
                            <th>Tên</th>
                            <th>Mô tả</th>
                            <th>Giá</th>
                            <th>Ảnh</th>
                        </tr>

                        <%
                            List<Product> products = (List<Product>) request.getAttribute("products");
                            if (products != null) {
                                for (Product p : products) {
                        %>
                        <tr>
                            <td><%= p.getId() %></td>
                            <td><%= p.getName() %></td>
                            <td><%= p.getDescription() %></td>
                            <td><%= p.getPrice() %></td>
                            <td>
                                <%
                                    if (p.getImg() != null && !p.getImg().isEmpty()) {
                                %>
                                    <img class="user-img"
                                         src="${pageContext.request.contextPath}/images/<%= p.getImg() %>"
                                         alt="<%= p.getName() %>">
                                <%
                                    } else {
                                %>
                                    Không có ảnh
                                <%
                                    }
                                %>
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
    </main>

    <%@ include file="/views/users/common/footer.jsp" %>
</div>