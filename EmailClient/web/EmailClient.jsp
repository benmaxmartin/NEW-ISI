<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email Sender</title>
    </head>
    <body>
        <h1>E-Mail</h1>
        <form method="POST" action="EmailServer">
            <table>
                <tr>
                    <th>To:</th>
                    <td><input type="text" name="to"></td>
                </tr>
                <tr>
                    <th>Subject:</th>
                    <td><input type="text" name="subject"></td>
                </tr>
                <tr>
                    <th>Message:</th>
                    <td><textarea name="body" cols="60" rows="20"></textarea></td>
                </tr>
                <tr>
                    <td> <input type="submit" value="Send"></td>
                </tr>
            </table>
          </form>
    </body>
</html>
