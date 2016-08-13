<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<%@ page import="com.client.EmailServlet"%>
<%@ page import="javax.mail.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<%! int i;%>
<%! int count = EmailServlet.messages.length; %>
<%! Message [] message = EmailServlet.messages ;%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email-Briefing</title>
    </head>
    <body>
        <h1>ISI:MAILS</h1>
        <table>
            <% for ( i = 0; i < count; i++){%>
            <tr>
            <td>Email Number:<%= i+1 %><br>
            Subject:<%=message[i].getSubject()%><br>
            From:<%=message[i].getFrom()[0]%><br>
            ContentType:<%=message[i].getContentType()%></td>
            <td>
                <form action="readMessage">
                            <input type ="hidden" name="message_no" value="<%=i%>">
                            <input type="submit" value="View-Mail" />
                </form>
            </td>
            </tr>
        <%}
        %>
            
        </table>
         
    </body>
</html>
