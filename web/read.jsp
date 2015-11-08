<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>My Favorite Actors</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Chun-Ting's Favorite Actors</h1>
        <%= table %>
        <br>
        <h2><a href="add">Add A New Actor</a></h2>
        <br>
        <h2><a href="search.jsp">Search Actors</a></h2>
    </body>
</html>