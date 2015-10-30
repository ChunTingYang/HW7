<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Actor</title>
    </head>
    <body>
        <h1>Add A New Actor</h1>
        
        <form name="addForm" action="addActor" method="get">
            
            <label>Actor Name:</label>
            <input type="text" name="name" value="" />
            <br>
            
            <label>Nationality:</label>
            <input type="text" name="nationality" value="" />
            <br>
            
            <label>Age:</label>
            <input type="text" name="age" value="" />
            <br>
            
            <label>Birthday:</label>
            <input type="text" name="birthday" value="" />
            <br>
            
            <input type="submit" name="add" value="Add" /><input type="reset" name="clear" value="Clear" />
        </form>
    </body>
</html>
