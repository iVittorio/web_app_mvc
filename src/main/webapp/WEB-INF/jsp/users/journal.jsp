<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/jsp/logout.jsp"/>

<h1>Journal</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Lection Name</th>
    </tr>
    <c:forEach var="journal" items="${list}">
        <tr>
            <td>${journal.name}</td>
        </tr>
    </c:forEach>
</table>
<a href="/users">Back to Users list</a>
<br/>
