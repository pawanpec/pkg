package com.spedia.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.springframework.stereotype.Component;

import com.spedia.utils.PropertyFileReader;


@Component("sMTPAuthenticator")
public class SMTPAuthenticator extends Authenticator {

	public PasswordAuthentication getPasswordAuthentication() {
		String username = PropertyFileReader.getValue(MailConstraints.MAIL_ADDRESS);
		String password = PropertyFileReader.getValue(MailConstraints.MAIL_PWS);
		return new PasswordAuthentication(username, password);
	}

}
