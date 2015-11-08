<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Actors"%>
<% Actors actor = (Actors) request.getAttribute("actor"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Update An Actor</title>
    </head>
    <body>
        <h1>Update An Actor</h1>
        
        <form name="updateForm" action="updateActor" method="get">
            
            <table class="update">
                <tr>
                <th>Actor ID:</th>
                <td class="right"><input type="text" name="id" value="<%= actor.getActorID() %>" readonly/></td>
                </tr>
                <tr>
                    <th>Actor Name:</th>
                    <td class="right"><input type="text" name="name" value="<%= actor.getActorName() %>" /></td>
                </tr>
                <tr>
                    <th>Nationality:</th>
                    <td class="right"><input type="text" name="nationality" value="<%= actor.getNationality() %>" /></td>
                </tr>
                <tr>
                    <th>Age:</th>
                    <td class="right"><input type="text" name="age" value="<%= actor.getAge() %>" /></td>
                </tr>
                <tr>
                    <th>Birthday:</th>
                    <td class="right"><input type="text" name="birthday" value="<%= actor.getBirthday() %>" /></td>
                </tr>  
            </table>
                <br>
                <input type="submit" name="update" value="Update" />
                <input type="reset" name="clear" value="Clear" />
        </form>
    </body>
</html>
