<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/auth.css">

<div class="auth-page">
    <div class="auth-box">
        <h2 class="auth-title">Đăng nhập</h2>

        <form action="${pageContext.request.contextPath}/auth" method="post">
            <input type="hidden" name="action" value="login"/>

            <div class="auth-form-group">
                <label>Username</label>
                <input type="text" name="name"/>
            </div>

            <div class="auth-form-group">
                <label>Password</label>
                <input type="password" name="password"/>
            </div>

            <button class="auth-button" type="submit">Login</button>
        </form>

        <div class="auth-link">
            <a href="${pageContext.request.contextPath}/auth?action=register">Register</a>
        </div>
    </div>
</div>