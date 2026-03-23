<form action="auth" method="post">
    <input type="hidden" name="action" value="register"/>

    Username: <input type="text" name="name"/><br/>
    Password: <input type="password" name="password"/><br/>

    <button type="submit">Register</button>
</form>

<a href="auth?action=login">Login</a>