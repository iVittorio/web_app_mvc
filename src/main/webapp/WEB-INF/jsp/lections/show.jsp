<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Read Lection</h1>
<table>
    <tr>
        <td>Name :</td>
        <td><input type="text" name="lectionName" disabled value="${lection.name}"/></td>
    </tr>
    <tr>
        <td>Text :</td>
        <td><label>
            <textarea rows="10" cols="45" name="text" disabled>${lection.text}</textarea>
        </label></td>
    </tr>
</table>
<a href="/lections">Back to lection List</a>
