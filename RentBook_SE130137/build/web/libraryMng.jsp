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
        <title>LibraryMng Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.fullName == null or !sessionScope.LOGIN_USER.roleID.equalsIgnoreCase('admin') or sessionScope.LOGIN_USER.isActive == false}">
            <c:redirect url="login.jsp"/>
        </c:if>

        <h1> Welcome ${sessionScope.LOGIN_USER.fullName}, your role: ${sessionScope.LOGIN_USER.roleID}</h1>
        <h1> Welcome to Library Manager!</h1>
        <a href="admin.jsp" > Back to AdminPage </a>
        </br>
        </br>
        ${requestScope.message}

        <form action="MainController" method="GET">
            Search <input type="text" name="txtSearch" value="${param.txtSearch}" />
            <input type="submit" value="SearchBookMng" name="btnAction" />
        </form>

        <c:if test="${requestScope.LIST_BOOK != null}">
            <c:if test="${not empty requestScope.LIST_BOOK}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>BookID</th>
                            <th>Title</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>IsActive</th>
                            <th>UpdateStatus</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="list" varStatus="counter" items="${requestScope.LIST_BOOK}">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${list.id}</td>
                                <td>${list.title}</td>
                                <td>${list.quantity}</td>
                                <td>${list.price}</td>
                                <td>${list.isActive}</td>
                                <td>
                                    <c:url var="UpdateStatus" value="MainController">
                                        <c:param name="btnAction" value="UpdateStatusBook"></c:param>
                                        <c:param name="txtBookID" value="${list.id}"></c:param>
                                        <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                                    </c:url>
                                    <a href="${UpdateStatus}">Remove</a>
                                </td>
                                <td>
                                    <form action="MainController">
                                        <input type="hidden" name="txtBookID" value="${list.id}" />
                                        <input type="hidden" name="txtTitle" value="${list.title}" />
                                        <input type="hidden" name="txtQuantity" value="${list.quantity}" />
                                        <input type="hidden" name="txtPrice" value="${list.price}" />
                                        <input type="hidden" name="txtIsActive" value="${list.isActive}" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                        <input type="submit" name="btnAction" value="UpdateBookPage" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>
        </br>

        <form action="MainController">
            <input type="submit" value="CreateBookPage" name="btnAction" />
        </form>      
    </body>
</html>
