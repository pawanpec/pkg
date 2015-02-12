package com.spedia.mail;

import java.util.Map;

public interface IMailService {
	public String getMessageContentVm(String vmfilename, Map<String, Object> model);

	public boolean sendMail(String to, String subject, String msgText);

	public boolean sendMail(String to, String subject, String vmFileName, Map<String, Object> model);
}
