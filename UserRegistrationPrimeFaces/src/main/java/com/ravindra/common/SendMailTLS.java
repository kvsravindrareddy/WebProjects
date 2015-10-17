package com.ravindra.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void forGotPasswordResetLink(String passwordResetLink, String recepient) {
		Properties prop = PropertiesLoader.loadSMTPGmailProperties();
		final String userName = prop.getProperty("gmail.userName");
		final String password = prop.getProperty("gmail.password");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
			message.setSubject("Password reset*******No Reply");
			message.setText("Click on the below link to reset the password... \n"+passwordResetLink);
			Transport.send(message);
			System.out.println("message send...");
		}catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void enquiryEmail(String visitorName, String visitorMobile, String visitorEmail, String msg) {
		Properties prop = PropertiesLoader.loadSMTPGmailProperties();
		final String userName = prop.getProperty("gmail.userName");
		final String password = prop.getProperty("gmail.password");
		final String recepient = prop.getProperty("gmail.recepients");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
			message.setSubject("Password reset*******No Reply");
			message.setText("Name : "+visitorName +"\nMobile : "+visitorMobile+"\nEmail : "+visitorEmail+"\n\n"+msg);
			Transport.send(message);
			System.out.println("message send...");
		}catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void acknowledgementToVisitor(String visitorName, String visitorEmail) {
		Properties prop = PropertiesLoader.loadSMTPGmailProperties();
		final String userName = prop.getProperty("gmail.userName");
		final String password = prop.getProperty("gmail.password");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(visitorEmail));
			message.setSubject("Password reset*******No Reply");
			message.setText("Hello  "+visitorName +" Thanks for visiting our site. \nwe will contact you soon");
			Transport.send(message);
			System.out.println("message send...");
		}catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
