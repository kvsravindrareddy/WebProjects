package com.ravindra.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
	public static Properties loadSMTPGmailProperties() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("D://STSWorkSpace/RavindraProjects/UserRegistrationPrimeFaces/src/main/resources/UserRegistration.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
}
