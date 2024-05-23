package com.SmartContactManager.SmartContactManagerSpring.service;
import jakarta.mail.*;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.NewsAddress;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {
public boolean sendEmail(String subject ,String message,String to)
{

    boolean f =false;
    // rest of the code
    // variable for gmail
    String host ="smtp.gmail.com";
String from="abhisheksharmabca2020@gmail.com";
    //get the system properties
    Properties properties=System.getProperties();
    System.out.println(properties);

    // setting importatnt information to properties object

    // host sent
    properties.put("mail.smtp.auth", true);
    properties.put("mail.smtp.starttls.enable", true);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.host", "smtp.gmail.com");

    // Stp :1 to get the session object
    Session session=Session.getInstance(properties, new Authenticator() {
    @Override
        protected PasswordAuthentication getPasswordAuthentication(){
       return new PasswordAuthentication("abhisheksharma2947@gmail.com","9919375538");
    }
    });
//
//    session.setDebug(true);

    // stp :2 Compose the message [text]
    Message m=new MimeMessage(session);

    try{
        m.setFrom(new NewsAddress(from));
// adding recipient to message
m.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
// adding subject
        m.setFrom(new InternetAddress(from));
        m.setSubject(subject);
// adding text to message
       // m.setText(message);
       m.setContent(message,"text/html");
        // send


        // step 3 : send the message using transport class
        Transport.send(m);
        System.out.println("Sent success email");
        f=true;

    } catch (MessagingException e) {
        throw new RuntimeException(e);

    }
return f;
}
}
