<%-- 
    Document   : search
    Created on : Jun 1, 2020, 1:08:44 PM
    Author     : haitu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.fullName == null or !sessionScope.LOGIN_USER.roleID.equalsIgnoreCase('admin') or !sessionScope.LOGIN_USER.isActive.equalsIgnoreCase('true')}">
            <c:redirect url="login.jsp"/>
        </c:if>

        <h1> Welcome to AdminPage ${sessionScope.LOGIN_USER.fullName}, your role: ${sessionScope.LOGIN_USER.roleID}</h1>
        <a href="MainController?btnAction=Logout" > Logout </a>
        </br>
        </br>
        <a href="MainController?btnAction=Search"> User Manager </a>
        </br>
        <a href="MainController?btnAction=SearchBookMng"> Book Manager </a>
    </body>
</html>
