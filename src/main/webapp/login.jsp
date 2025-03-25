<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="chkb.dev_avancee1.model.UserBean" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<%
    HttpSession existingSession = request.getSession(false);
    if (existingSession != null && existingSession.getAttribute("user") != null) {
        response.sendRedirect("page1.jsp");
        return;
    }
%>
<h1>Login</h1>
<form action="login.do" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
    <br/>
    <input type="submit" value="Login">
</form>
</body>
</html>