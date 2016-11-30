<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Journal</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Lection Name</th>
    </tr>
    <c:forEach var="journal" items="${list}">
        <tr>
            <td>${journal.lectionName}</td>
        </tr>
    </c:forEach>
</table>
<a href="/users">Back to users list</a>
<br/>
