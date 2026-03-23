<%-- LTWeb01\src\main\webapp\views\admin\products\add.jsp --%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.iotstart.models.Category" %>

<h2>Thêm sản phẩm</h2>

<form action="${pageContext.request.contextPath}/admin/product/add" method="post" enctype="multipart/form-data">

    Name: <input type="text" name="name"><br>

    Description: <textarea name="description"></textarea><br>

    Price: <input type="text" name="price"><br>

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

    Amount: <input type="text" name="amount"><br>

    Stock: <input type="text" name="stock"><br>

    Image: <input type="file" name="file"><br>

    <button type="submit">Save</button>
</form>

<a href="${pageContext.request.contextPath}/admin/product">Back</a>
