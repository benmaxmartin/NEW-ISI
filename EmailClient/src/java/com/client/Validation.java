package com.client;
import javax.mail.*;
public class Validation {
    static Authenticator Valid(String username,String password ){
       Authenticator auth;
        auth = new Authenticator() {
                private final PasswordAuthentication pa = new PasswordAuthentication(username, password);
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return pa;
                }
            };
        return auth;
        }
}
