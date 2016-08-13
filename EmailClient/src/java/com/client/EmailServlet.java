
package com.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailServlet extends HttpServlet {
   public static Message[] messages = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
       String password= request.getParameter("password");
       RecvEmail.fetch(username,password);
       request.getSession().setMaxInactiveInterval(1800);
       request.getSession().setAttribute("message",messages);
         // Message[] messages = obj.fetch(username,password);
         /* System.out.println("Length:"+messages.length);
      for (int i = 0; i <messages.length ; i++){
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println("Email Number " + (i + 1));
            System.out.println("Subject: " + messages[i].getSubject());
            System.out.println("From: " + messages[i].getFrom()[0]);
            System.out.println("ContentType:"+messages[i].getContentType());
        
       
        }*/
      
       
response.sendRedirect("briefMessage.jsp");
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        processRequest(request, response);    
        }
        catch(MessagingException e){e.printStackTrace();}
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        processRequest(request, response);    
        }
        catch(MessagingException e){e.printStackTrace();}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
