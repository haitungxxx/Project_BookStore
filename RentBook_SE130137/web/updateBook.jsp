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
        <form action="MainController">
            BookID <input type="text" name="txtBookID" value="${param.txtBookID}" readonly="true" />
            </br>
            Title <input type="text" name="txtTitle" value="${param.txtTitle}" />
            </br>
            Price <input type="text" name="txtPrice" value="${param.txtPrice}" />
            </br>
            Quantity <input type="text" name="txtQuantity" value="${param.txtQuantity}" />
            </br>
            IsActive <input type="text" name="txtIsActive" value="${param.txtIsActive}" />
            </br>
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="submit" name="btnAction" value="UpdateBook"/>
        </form>
    </body>
</html>
