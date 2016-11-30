<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<h1>Lections List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Show</th>
        <sec:authorize access="hasRole('ROLE_TEACHER')">
            <th>Edit</th>
            <th>Delete</th>
        </sec:authorize>
    </tr>
    <c:forEach var="lection" items="${list}">
        <tr>
            <td>${lection.id}</td>
            <td>${lection.name}</td>
            <td><a href="lections/show/${lection.id}">Show</a></td>
            <sec:authorize access="hasRole('ROLE_TEACHER')">
                <td><a href="lections/edit/${lection.id}">Edit</a></td>
                <td><a href="lections/delete/${lection.id}">Delete</a></td>
            </sec:authorize>
        </tr>
    </c:forEach>
</table>
<sec:authorize access="hasRole('ROLE_TEACHER')">
    <a href="/lections/add">Add new Lection</a>
    <p/>
    <a href="/users">User List</a>
    <br/>
</sec:authorize>