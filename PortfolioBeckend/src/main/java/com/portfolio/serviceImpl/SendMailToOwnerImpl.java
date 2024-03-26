package com.portfolio.serviceImpl;

import java.util.Properties;

import org.springframework.stereotype.Service;

import com.portfolio.entities.ContactMe;
import com.portfolio.service.SendMailToOwner;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class SendMailToOwnerImpl implements SendMailToOwner {

	@Override
	public void sendMail(ContactMe contactDetails) {
		
		System.out.println(contactDetails);
		final String username="hannanshaikh150";
        final String password="eviqxqdfpzzzvxgj";
		
		//Setting up the mail properties
		Properties props = new Properties();
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.port",587);
		
		
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);};
				}
				);
		
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(contactDetails.getEmail()));
			message.setRecipient(RecipientType.TO, new InternetAddress("hannanshaikh150@gmail.com"));
			message.setSubject(contactDetails.getSubject());
			message.setText(contactDetails.getMessage());
			
			Transport.send(message);
			System.out.print("Email Sends Successfully");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("\n Something is wrong");
		}
	}

}
