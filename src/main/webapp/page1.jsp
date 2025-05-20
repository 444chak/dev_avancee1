<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="chkb.dev_avancee1.model.UserBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page 1</title>
</head>
<body>
<%
    UserBean user = (UserBean) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<h1>Welcome, <%= user.getNom() %>!</h1>
<form  method="post">
    <label for="attribut1">Attribut 1:</label>
    <input type="text" id="attribut1" name="attribut1" value="<%= user.getAttribut1() %>">
    <br/>
    <label for="attribut2">Attribut 2:</label>
    <input type="text" id="attribut2" name="attribut2" value="<%= user.getAttribut2() %>">
    <br/>
    <input type="submit" value="Validate" formaction="validateAttributes.do">
    <input type="submit" value="Update" formaction="updateAttributes.do">
</form>
<br/>
<form action="logout.do" method="get">
    <input type="submit" value="Logout">
</form>
</body>
</html>