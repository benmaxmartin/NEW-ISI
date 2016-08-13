
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="com.client.readMessage"%>

<!DOCTYPE html>
<%!String str; %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reading-Message</title>
    </head>
    <body>
        <h1>Reading-Message</h1>
        <h3>Cipher-Text:</h3>
        <p>
            <%=readMessage.text%>
        </p>
        <h3>Captcha:</h3>
        
        <img src="<%= readMessage.path %>">
       
        <h3>Enter The Above Captcha to Decrypt!!</h3>
        <form action="decryptServlet">
            <input type="hidden" name="body" value="<%=readMessage.text%>">
            <input type="text" name="captcha">
            <input type="submit" value="Continue">    
        </form>
            <form action="EmailServlet">
                <input type="submit" value="go-back">
            </form>   
            
    </body>
</html>
