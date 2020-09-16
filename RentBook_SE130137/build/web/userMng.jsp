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
        <title>UserMng Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.fullName == null or !sessionScope.LOGIN_USER.roleID.equalsIgnoreCase('admin') or sessionScope.LOGIN_USER.isActive == false}">
            <c:redirect url="login.jsp"/>
        </c:if>

        <h1> Welcome ${sessionScope.LOGIN_USER.fullName}, your role: ${sessionScope.LOGIN_USER.roleID}</h1>
        <h1> Welcome to User Manager </h1>
        <a href="admin.jsp" > Back to AdminPage </a>
        </br>
        </br>
        ${requestScope.message}
        
        <form action="MainController" method="GET">
            Search <input type="text" name="txtSearch" value="${param.txtSearch}" />
            <input type="submit" value="Search" name="btnAction" />
        </form>

        <c:if test="${requestScope.LIST_USER != null}">
            <c:if test="${not empty requestScope.LIST_USER}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>UserID</th>
                            <th>FullName</th>
                            <th>Password</th>
                            <th>RoleID</th>
                            <th>IsActive</th>
                            <th>Ban account</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="list" varStatus="counter" items="${requestScope.LIST_USER}">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${list.userID}</td>
                                <td>${list.fullName}</td>
                                <td>${list.password}</td>
                                <td>${list.roleID}</td>
                                <td>${list.isActive}</td>
                                <td>
                                    <c:url var="Ban" value="MainController">
                                        <c:param name="btnAction" value="Ban"></c:param>
                                        <c:param name="txtUserID" value="${list.userID}"></c:param>
                                        <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                                    </c:url>
                                    <a href="${Ban}">Ban</a>
                                </td>
                                <td>
                                    <form action="MainController">
                                        <input type="hidden" name="txtUserID" value="${list.userID}" />
                                        <input type="hidden" name="txtFullName" value="${list.fullName}" />
                                        <input type="hidden" name="txtRoleID" value="${list.roleID}" />
                                        <input type="hidden" name="txtIsActive" value="${list.isActive}" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />    
                                        <input type="submit" name="btnAction" value="UpdatePage" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>
    </body>
</html>
