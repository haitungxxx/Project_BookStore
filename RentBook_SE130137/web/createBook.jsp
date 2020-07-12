<%-- 
    Document   : register
    Created on : Jul 4, 2020, 6:16:02 PM
    Author     : haitu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreateBook Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.fullName == null or !sessionScope.LOGIN_USER.roleID.equalsIgnoreCase('admin') or !sessionScope.LOGIN_USER.isActive.equalsIgnoreCase('true')}">
            <c:redirect url="login.jsp"/>
        </c:if>
            
        <h1>Create Book</h1>
        <form action="MainController" method="GET">
            BookID <input type="text" name="txtBookID" value="" /></br>
            ${requestScope.ERROR_BOOK.idError}
            </br></br>
            Title <input type="text" name="txtTitle" value="" /></br>
            ${requestScope.ERROR_BOOK.titleError}
            </br></br>
            Price <input type="text" name="txtPrice" value="" /></br>
            ${requestScope.ERROR_BOOK.priceError}
            </br></br>
            Quantity <input type="text" name="txtQuantity" value="" /></br>
            ${requestScope.ERROR_BOOK.quantityError}
            </br></br>
            IsActive <input type="text" name="txtIsActive" value="" /></br>
            ${requestScope.ERROR_BOOK.isActiveError}
            </br></br>
            <input type="submit" value="CreateBook" name="btnAction" />
        </form>
    </body>
</html>
