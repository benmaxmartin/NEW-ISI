
package com.client;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.SMTPMessage;
import javax.servlet.http.HttpServletResponse;
public class SendEmail {
    private static final int port=587;
    private static final String host="smtp.gmail.com";
   static void email(String to,String subject,String body) throws IOException{
        Properties prop=new Properties();
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.port", port);
        HttpServletResponse response = null;
        try{
            Session session = Session.getInstance(prop,LoginServlet.obj);
            SMTPMessage msg = new SMTPMessage(session);
            msg.setFrom(new InternetAddress(LoginServlet.username));
            InternetAddress[] addr = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO,addr);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
         
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart msgPart =new MimeBodyPart();
            msgPart.setText(body);
            multipart.addBodyPart(msgPart);
            MimeBodyPart imgPart = new MimeBodyPart();
            File fp = new File("C:\\Users\\007\\Documents\\NetBeansProjects\\EmailClient\\web\\image.png");
            imgPart.attachFile(fp);
            multipart.addBodyPart(imgPart);
            msg.setContent(multipart);
            Transport.send(msg);
        }
        catch(MessagingException e){
            throw new RuntimeException(e);
        }
                
    }
}
