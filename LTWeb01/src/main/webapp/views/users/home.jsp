<%-- LTWeb01\src\main\webapp\views\users\home.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>My Web</title>
</head>
<body>

    <%@ include file="/views/users/common/header.jsp" %>

    <div>
        <sitemesh:write property="body"/>
    </div>

    <%@ include file="/views/users/common/footer.jsp" %>

</body>
</html>