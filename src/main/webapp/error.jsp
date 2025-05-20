<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>Error</h1>
<p>
    <% String errorMessage = (String) session.getAttribute("errorMessage"); %>
    <%= errorMessage != null ? errorMessage : "An unknown error occurred." %>
</p>
<br/>
<a href="javascript:history.back()">Retour à la page précédente</a>
</body>
</html>