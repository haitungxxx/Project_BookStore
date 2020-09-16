<%-- 
    Document   : login
    Created on : Jul 5, 2020, 4:11:27 PM
    Author     : haitu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">        
            UserID <input type="text" name="txtUserID" value="${sessionScope.userID}">
            </br>
            Password <input type="password" name="txtPassword">
            </br>
            ${sessionScope.message}
            </br>
            <input type="submit" value="Login" name="btnAction" />
            <input type="reset" value="Reset" name="btnReset" />
            </br>
            <a href="register.jsp"> Register </a>
        </form>
    </body>
</html>
