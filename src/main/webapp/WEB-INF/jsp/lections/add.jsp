<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/jsp/logout.jsp"/>

<h1>Add Lection</h1>
<form:form method="POST" action="/lections/addsave">
    <table>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Text :</td>
            <td><label>
                <textarea rows="10" cols="45" name="text"></textarea>
            </label></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add Lecion"/></td>
        </tr>
    </table>
</form:form>
<a href="/lections">Back to Lection list</a>
