<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/jsp/logout.jsp"/>

<h1>Users List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Full Name</th>
        <th>email</th>
        <th>Role</th>
        <th>Sex</th>
        <th>Journal</th>
    </tr>
    <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.fullName}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>${user.sex}</td>
            <td><a href="users/journal/${user.id}">Show</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/lections">Back to Lection list</a>
<br/>