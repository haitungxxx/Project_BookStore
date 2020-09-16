<%-- 
    Document   : update
    Created on : Jun 10, 2020, 12:48:51 PM
    Author     : haitu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
    <c:if test="${sessionScope.LOGIN_USER.fullName == null or !sessionScope.LOGIN_USER.roleID.equalsIgnoreCase('admin') or sessionScope.LOGIN_USER.isActive == false}">
        <c:redirect url="login.jsp"/>
    </c:if>
    <form action="MainController">
        BookID <input type="text" name="txtBookID" value="${param.txtBookID}" readonly="true" /></br>
        </br></br>
        Title <input type="text" name="txtTitle" value="${param.txtTitle}" /></br>
        ${requestScope.ERROR_BOOK.titleError}
        </br></br>
        Price <input type="text" name="txtPrice" value="${param.txtPrice}" /></br>
        ${requestScope.ERROR_BOOK.priceError}
        </br></br>
        Quantity <input type="text" name="txtQuantity" value="${param.txtQuantity}" /></br>
        ${requestScope.ERROR_BOOK.quantityError}
        </br></br>
        IsActive <select name="cmbIsActive">
            <option value="true"> True </option>
            <option value="false"> False </option>
        </select>
        </br></br>
        <input type="submit" name="btnAction" value="UpdateBook"/>
    </form>
</body>
</html>
