package com.spedia.mail;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.spedia.utils.PropertyFileReader;
import com.spedia.utils.VelocityConstraints;


public class MailServiceImpl implements IMailService {

	@Autowired
	@Qualifier("velocityEngine")
	private VelocityEngine velocityEngine;

	@Autowired
	@Qualifier("sMTPAuthenticator")
	private Authenticator defaultAuthenticator;


	public static final String MAIL_APPLICATION_URL_PROPERTY_KEY  = "application.mail.url";
	
	public boolean sendMail(String to, String subject, String msgText) {
		boolean result = sendMail(to, null, subject, msgText);
		return result;

	}
	
	public boolean sendMail(String to, String subject, String vmFileName, Map<String, Object> model) {
		String msgText = getMessageContentVm(vmFileName, model);
		boolean result = sendMail(to, null, subject, msgText);
		return result;

	}
	/**
	 * Method sendMail
	 * 
	 * @param from1String
	 * @param toString
	 * @param ccString
	 * @param bccString
	 * @param subjectString
	 * @param msgTextString
	 * 
	 * @return boolean
	 */
	private boolean sendMail(String to, String cc, String subject, String msgText) {

		// set the host
		try {
			Properties props = new Properties();
//			private final String HOST_NAME = ;
			props.put("mail.smtp.host", PropertyFileReader.getValue(MailConstraints.MAIL_SMPT_HOST));
//			props.put("mail.smtp.host", "192.168.206.193");
			// create some properties and get the default Session
			Session session = Session.getInstance(props, null);
			session.setDebug(false);

			// create a message
			Message msg = new MimeMessage(session);

			// set the from
			InternetAddress From = new InternetAddress(PropertyFileReader.getValue(MailConstraints.MAIL_FROM_ID));
			msg.setFrom(From);

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			if (cc != null) {
				msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
			}

			msg.setSubject(subject);

			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent(msgText, "text/html");

			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			msg.setContent(mp);
			msg.setSentDate(new Date());
			msg.setHeader("X-Mailer", "TimesClassifieds");
			// log.info(host);

			Transport.send(msg);
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	//	logger.info("mail sent : from ::" + PropertyFileReader.getValue(MailConstraints.MAIL_FROM_ID) + " :: host :: " + PropertyFileReader
	//			.getValue(MailConstraints.MAIL_SMPT_HOST));
		return true;
	}

	public java.io.File getVmFile(String fileName) {
		File vmfile = null;
		try {
			vmfile = new File(getClass().getClassLoader()
					.getResource(System.getProperty("file.separator") + "vmtemplate" + System.getProperty("file.separator") + fileName).toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return vmfile;
	}

	public String getMessageContentVm(String vmFile, Map<String, Object> model) {
		String result = null;
		try {
			result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, vmFile, VelocityConstraints.ENCODE_UTF_8, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

}
