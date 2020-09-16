<%-- 
    Document   : view
    Created on : Jun 13, 2020, 1:11:39 PM
    Author     : haitu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER.fullName == null or !sessionScope.LOGIN_USER.roleID.equalsIgnoreCase('user') or sessionScope.LOGIN_USER.isActive == false}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <a href="MainController?btnAction=SearchBook" > Back to Library </a>
        </br>
        </br>
        ${requestScope.message}
        
        <c:choose>
            <c:when test="${not empty sessionScope.CART}">
                <c:choose>
                    <c:when test="${sessionScope.CART.cart.size() > 0}">
                        <h1>Your selected Book: </h1>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Total</th>
                                    <th>Delete</th>
                                    <th>Update</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="total" value="0" />
                                <c:forEach var="cart" varStatus="counter" items="${sessionScope.CART.cart}">
                                    <c:set var="total" value="${total + (cart.value.price * cart.value.quantity) }" />
                                <form action="MainController">
                                    <tr>
                                        <td>${counter.count}</td>
                                        <td>${cart.value.id}</td>
                                        <td>${cart.value.title}</td>
                                        <td>
                                            <input type="text" value="${cart.value.quantity}" name="txtQuantity" />
                                        </td>
                                        <td>${cart.value.price}</td>
                                        <td>${cart.value.price * cart.value.quantity}</td>
                                        <td> 
                                            <input type="hidden" value="${cart.value.id}" name="txtID" /> 
                                            <input type="submit" value="RemoveBook" name="btnAction" />
                                        </td>
                                        <td> 
                                            <input type="submit" value="UpdateQuantity" name="btnAction" />
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1>Total: ${total}</h1>

                    </br>
                    <form action="MainController">
                        <input type="hidden" value="${total}" name="txtTotal" /> 
                        <input type="submit" value="CheckOut" name="btnAction" />
                    </form>
                </c:when>
                <c:otherwise>
                    <h1>Dont have any books in the cart!</h1>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <h1>Dont have any books in the cart!</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
