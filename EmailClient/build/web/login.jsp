<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation page</title>
    </head>
    <body>
        <form method="POST" action="LoginServlet">
            <table>
                <tr>
                    <th>UserName:</th>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td><input type ="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Validate"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
