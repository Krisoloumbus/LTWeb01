<%-- LTWeb01\src\main\webapp\WEB-INF\decorators\admin.jsp --%>
<%@ taglib prefix="sitemesh" uri="http://www.sitemesh.org/sitemesh" %>

<html>
<head>
	<title>Admin</title>
	<style>
	    body { font-family: Arial; margin: 0; }
	    .container { display: flex; }
	    .sidebar {
	        width: 220px;
	        background: #333;
	        color: white;
	        min-height: 100vh;
	        padding: 20px;
	    }
	    .sidebar a {
	        display: block;
	        color: white;
	        text-decoration: none;
	        margin: 10px 0;
	    }
	    .sidebar a:hover { background: #555; padding-left: 5px; }
	    .content { flex: 1; padding: 20px; }
	</style>
</head>
<body>

    <%@ include file="/views/admin/common/header.jsp" %>
	<div class="container">

	    <div class="sidebar">
	        <h3>ADMIN</h3>

	        <a href="${pageContext.request.contextPath}/admin/home">Dashboard</a>

	        <hr/>

	        <b>Category</b>
	        <a href="${pageContext.request.contextPath}/admin/category">Quan ly Category</a>

	        <b>Product</b>
	        <a href="${pageContext.request.contextPath}/admin/product">Quan ly Product</a>

			<b>User</b>
			<a href="${pageContext.request.contextPath}/admin/user/">Quan ly User</a>

	    </div>

		<div>
		        <sitemesh:write property="body"/>
		   </div>

	</div>
   

    <%@ include file="/views/users/common/footer.jsp" %>

</body>
</html>