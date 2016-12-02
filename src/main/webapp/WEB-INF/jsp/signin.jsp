<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h3>Sign In</h3>
<font color="red">
    ${SPRING_SECURITY_LAST_EXCEPTION.message}
</font>
<form action="<%=request.getContextPath()%>/appLogin" method="POST">
    Enter UserName: <input type="text" name="username"/><br/><br/>
    Enter Password: <input type="password" name="password"/> <br/><br/>
    <input type="submit" value="Login"/>
    <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
    <label for="remember_me" class="inline">Remember me</label>
</form>
</body>
<a href="/signup">SignUp</a>
</html>