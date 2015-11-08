<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Search Actors</title>
    </head>
    <body>
        <div class="wrap">
            <%@include file="includes/header.jsp" %>
            <%@include file="includes/menu.jsp" %>
            
            <div class="main">
                <h1>Search Actors</h1>
        
                <form name="searchForm" action="search" method="get">
            
                <input type="text" name="searchVal" value="" />
                <br><br>
                <input type="submit" name="submit" value="Search" />
                </form>
            </div>
            <div class="footer"><%@include file="includes/footer.jsp" %></div>
    </div>
    </body>
</html>
