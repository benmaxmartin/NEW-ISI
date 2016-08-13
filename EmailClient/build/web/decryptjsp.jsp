<%@page import = "com.client.decryptServlet" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Decrypted Message</title>
    </head>
    <body>
        <h1>Decrypted Message:</h1>
        <p><%= decryptServlet.text%></p>
        click<a href='briefMessage.jsp'>here</a>to view other mails<br>
        click<a href='Welcome.jsp'>here</a>to go to main page
    </body>
</html>
