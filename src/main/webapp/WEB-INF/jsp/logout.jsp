<form action="<%=request.getContextPath()%>/logout" method="POST">
    <p align="right"><input type="submit" value="Logout"/></p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>