package edu.vub.ns.webcore.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.vub.ns.webcore.manager.impl.ManagerImpl;

public class EmailSender extends ManagerImpl{
	
	public static void main(String [] args) throws MessagingException{

		String to = "mahfuzcmt@gmail.com";
	    String subject = "New Notification";
	    String msg ="<b>Hello</b>"+ " New Notification";
	    final String from ="callingforsalat@gmail.com";
	    final  String password ="123!salat";

	    Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");  
	    Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(from,password);  
	   }  
	   });  

	   Transport transport = session.getTransport();  
	   InternetAddress addressFrom = new InternetAddress(password);  
	   MimeMessage message = new MimeMessage(session);  
	   message.setSender(addressFrom);  
	   message.setSubject(subject);  
	   message.setContent(msg, "text/html");  
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	   transport.connect();  
	   Transport.send(message);  
	   transport.close();
	   }  
	}
