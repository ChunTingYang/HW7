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
        <div class="wrap">
            <%@include file="includes/header.jsp" %>
            <%@include file="includes/menu.jsp" %>
            
            <div class="main">
                <h1>Chun-Ting's Favorite Actors</h1>
                <%= table %>
                <br>
                <p><a href="add">Add A New Actor</a></p>
                <p><a href="search.jsp">Search Actors</a></p>
            </div>  
            <div class="footer"><%@include file="includes/footer.jsp" %></div>         
    </div>
    </body>
</html>