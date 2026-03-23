<form action="auth" method="post">
    <input type="hidden" name="action" value="login"/>

    Username: <input type="text" name="name"/><br/>
    Password: <input type="password" name="password"/><br/>

    <button type="submit">Login</button>
</form>

<a href="auth?action=register">Register</a>

