
package com.client;

import java.io.*;
import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class readMessage extends HttpServlet {
            public static String text,path;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().setMaxInactiveInterval(1800);
        try{
            int count = 0;
		for(int i=0;i<request.getParameter("message_no").length();i++){
			count = (count*10)+((int)request.getParameter("message_no").charAt(i))-48;
		}
                System.out.println(count);
           path="image_recv"+count+".png";      
          Message message=EmailServlet.messages[count];
          request.getSession().setAttribute("message",message);
           Multipart mp=(Multipart)message.getContent();
            for(int i=0;i<mp.getCount();i++){
                BodyPart bp=mp.getBodyPart(i);
                System.out.println(bp.getContentType());
                if(bp.getContentType().contains("text/plain")){
                text=(String)bp.getContent(); 
                }
                request.getSession().setAttribute("text",text);
                 if(bp.getContentType().contains("/octet-stream")){
                   InputStream in_str = bp.getInputStream();
                    byte [] buffer = new byte[in_str.available()];
                    in_str.read(buffer);
                    File fp = new File("C:/Users/007/Documents/NetBeansProjects/EmailClient/web/"+path);
                    OutputStream os = new FileOutputStream(fp);
                    //OutputStream os = response.getOutputStream();
                    os.write(buffer);
                   
                   
                }
            }
        }    
        catch(Exception e){e.printStackTrace();}
        response.sendRedirect("readMessage.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
