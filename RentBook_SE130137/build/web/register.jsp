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
        <title>Register Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="MainController" method="POST">
            UserID <input type="text" name="txtUserID" value="" /></br>
            ${requestScope.ERROR.userIDError}
            </br></br>
            FullName <input type="text" name="txtFullName" value="" /></br>
            ${requestScope.ERROR.fullNameError}
            </br></br>
            Password <input type="password" name="txtPassword" value="" /></br>
            ${requestScope.ERROR.passwordError}
            </br></br>
            RePassword <input type="password" name="txtRePassword" value="" /></br>
            ${requestScope.ERROR.rePasswordError}
            </br></br>
            <input type="submit" value="Register" name="btnAction" />
        </form>
    </body>
</html>
