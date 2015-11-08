<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Add A New Actor</title>
    </head>
    <body>
        <h1>Add A New Actor</h1>
        
        <form name="addForm" action="addActor" method="get">
            <table class="add">
                    <tr>
                        <th>Actor Name:</th>
                        <td class="right"><input type="text" name="name" value="" /></td>
                    </tr>
                    <tr>
                        <th>Nationality:</th>
                        <td class="right"><input type="text" name="nationality" value="" /></td>
                    </tr>
                    <tr>
                        <th>Age:</th>
                        <td class="right"><input type="text" name="age" value="" /></td>
                    </tr>
                    <tr>
                      <th>Birthday:</th>
                      <td class="right"><input type="text" name="birthday" value="" /></td>
                    </tr>
            </table>
            <br>
            <input type="submit" name="add" value="Add" />
            <input type="reset" name="clear" value="Clear" />
        </form>
    </body>
</html>
