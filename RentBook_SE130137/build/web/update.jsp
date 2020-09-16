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
            UserID <input type="text" name="txtUserID" value="${param.txtUserID}" readonly="true" />
            </br>
            FullName <input type="text" name="txtFullName" value="${param.txtFullName}" />
            </br>
            Password <input type="text" name="txtPassword" value="${param.txtPassword}" />
            </br>   
            RoleID <input type="text" name="txtRoleID" value="${param.txtRoleID}" />
            </br>         
            IsActive <select name="cmbIsActive">
                <option value="true"> True </option>
                <option value="false"> False </option>
            </select>
            </br></br>
            <input type="submit" name="btnAction" value="Update"/>
        </form>
    </body>
</html>
