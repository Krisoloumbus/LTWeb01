<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="vn.iotstart.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.Category" %>

<%
    Product p = (Product) request.getAttribute("product");
%>

<h2>Sửa sản phẩm</h2>

<form action="${pageContext.request.contextPath}/admin/product/edit/<%=p.getId()%>" method="post" enctype="multipart/form-data">

    Name: <input type="text" name="name" value="<%=p.getName()%>"><br>

    Description:
    <textarea name="description"><%=p.getDescription()%></textarea><br>

    Price: <input type="text" name="price" value="<%=p.getPrice()%>"><br>

	Category:
	<select name="category_id">
	    <%
	        List<Category> categories = (List<Category>) request.getAttribute("categories");
	        for (Category c : categories) {
	    %>
	        <option value="<%=c.getId()%>">
	            <%=c.getName()%>
	        </option>
	    <%
	        }
	    %>
	</select>
	<br>

    Amount: <input type="text" name="amount" value="<%=p.getAmount()%>"><br>

    Stock: <input type="text" name="stock" value="<%=p.getStock()%>"><br>

    <p>Ảnh hiện tại:</p>
    <img src="<%=request.getContextPath()%>/images/<%=p.getImg()%>" width="100"><br>

    Image mới: <input type="file" name="file"><br>

    <button type="submit">Update</button>
</form>

<a href="${pageContext.request.contextPath}/admin/product/">Back</a>