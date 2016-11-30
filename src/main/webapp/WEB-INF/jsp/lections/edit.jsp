<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Edit Lection</h1>
<form:form method="POST" action="/lections/editsave">
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Text :</td>
            <td><form:textarea rows="10" cols="45" path="text"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit Save"/></td>
        </tr>
    </table>
</form:form>