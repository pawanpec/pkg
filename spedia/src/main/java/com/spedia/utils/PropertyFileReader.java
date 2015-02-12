package com.spedia.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * Utility class for reading properties from files
 * 
 */
@Component
public class PropertyFileReader implements Serializable, MessageSourceAware {
	
	private static final long serialVersionUID = -137284886212268916L;
	public static MessageSource messageSource;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		PropertyFileReader.messageSource = messageSource;
	}

	/**
	 * Fetches value corresponding to a key
	 * If nothing is found returns the key itself
	 * @param key
	 * @return value
	 */
	public static String getValue(String key) {
		String value = "";
		if (!SocialUtility.chkNull(key)) {
			if (messageSource != null) {
				value = messageSource.getMessage(key, null, Locale.ENGLISH);	
			} else {
				 value = applicationConfigReader(key);
			}
			
		}
		return value;
	}

	private static String applicationConfigReader(String key) {
		String file = "common.properties";
		PropertyFileReader propertyFileReader = new PropertyFileReader();
		String title = propertyFileReader.fileReader(file, key);
		return title;
	}

	private String fileReader(String file, String key) {
		String val = "";
		Properties prop = new Properties();
		try {
			InputStream fis = this.getClass().getClassLoader().getResourceAsStream(file);
			prop.load(fis);
			val = prop.getProperty(key);
			//			log.debug("file = " + file + " | key = " + key + " | title = " + title);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	

}
