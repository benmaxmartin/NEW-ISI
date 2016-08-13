
package com.client;

import java.util.*;
import javax.mail.*;
public class RecvEmail {

    public static void fetch(String user,String password) {
        int count=0;
	  try {
         Properties properties = new Properties();
         properties.put("mail.store.protocol", "pop3");
         properties.put("mail.pop3.host", "pop.gmail.com");
         properties.put("mail.pop3.port", "995");
         properties.put("mail.pop3.starttls.enable", "true");
         Session emailSession = Session.getDefaultInstance(properties);
         Store store = emailSession.getStore("pop3s");

         store.connect("pop.gmail.com", user, password);

         Folder emailFolder = store.getFolder("INBOX");
         emailFolder.open(Folder.READ_ONLY);
         
         Message[] messages = emailFolder.getMessages();
         EmailServlet.messages = messages;
        for(int i=0;i<messages.length;i++){
            if(messages[i].getSubject().contains("ISI:")){
                count++;
            }
        }
        Message[] isi_messages = new Message[count];
        count=0;
        for(int i=0;i<messages.length;i++){
            if(messages[i].getSubject().contains("ISI:")){
               isi_messages[count]=messages[i];
               count++;
            }
        }
         EmailServlet.messages = isi_messages;     
              
            
       // emailFolder.close(false);
        //store.close();

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
         // return isi_messages;
   }

}

